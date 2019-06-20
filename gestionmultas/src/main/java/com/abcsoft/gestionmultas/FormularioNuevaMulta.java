package com.abcsoft.gestionmultas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.abcsoft.gestionmultas.model.Multa;
import com.abcsoft.gestionmultas.model.Tipo;
import com.abcsoft.gestionmultas.services.MultaServices;
import com.abcsoft.gestionmultas.services.impl.MultaServicesImpl;

import java.util.Date;

public class FormularioNuevaMulta extends AppCompatActivity {

    private MultaServices multaServices;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.nueva_multa);
            multaServices = MultaServicesImpl.getInstance();
        }

        public void guardar(View view){


            EditText textCodigo = (EditText) findViewById(R.id.idCodigo);
            EditText textImporte = (EditText) findViewById((R.id.idImporte));

            //Creo nueva multa y le paso los valores del formulario
            Multa multa = new Multa();
            multa.setCodigo(Long.parseLong(textCodigo.getText().toString()));
            multa.setFechaHora(new Date());
//            multa.setAgente(agente1);
            multa.setMotivo("Motivo....");
            multa.setObservaciones("Observaciones...");
            multa.setImporte(Double.parseDouble(textImporte.getText().toString()));
            multa.setTipo(com.abcsoft.gestionmultas.model.Tipo.LEVE);
            multa.setAceptada(true);

            // Vamos a persistir la multa...
            multaServices.create(multa);

            //Instanciamos un intent
            Intent intent = new Intent(this, MainActivity.class);

            //Cambiamos de activity
            startActivity(intent);

        }

}
