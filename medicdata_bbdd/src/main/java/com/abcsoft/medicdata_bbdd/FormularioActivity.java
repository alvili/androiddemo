package com.abcsoft.medicdata_bbdd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.abcsoft.medicdata_bbdd.model.Lectura;
import com.abcsoft.medicdata_bbdd.model.LecturaServices;
import com.abcsoft.medicdata_bbdd.model.LecturaServicesSQLite;

import java.util.Date;



public class FormularioActivity extends AppCompatActivity {

    private LecturaServices lecturaServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        //lecturaServices = LecturaServicesImpl.getInstance();
        lecturaServices = new LecturaServicesSQLite(this);
    }

    public void enviar(View view){

        EditText editPeso = (EditText) findViewById(R.id.idEntradaPeso);
        EditText editDiastolica = (EditText) findViewById((R.id.idEntradaDiastolica));
        EditText editSistolica = (EditText) findViewById(R.id.idEntradaSistolica);

        double peso = Double.parseDouble(editPeso.getText().toString());
        double diastolica = Double.parseDouble(editDiastolica.getText().toString());
        double sistolica = Double.parseDouble(editSistolica.getText().toString());

        // Vamos a instanciar una lectura...

        Lectura lectura = new Lectura(new Date(), peso, diastolica, sistolica);

        // Vamos a persistir la lectura...

        lecturaServices.create(lectura);

        // Vamos a instanciar un intent...

        Intent intent = new Intent(this, ListActivity.class);

        // Vamos a cambiar de activity...

        Log.d("****","Vamos a startActivity...");

        startActivity(intent);

    }

}
