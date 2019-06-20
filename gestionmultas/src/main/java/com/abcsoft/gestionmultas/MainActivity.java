package com.abcsoft.gestionmultas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.abcsoft.gestionmultas.model.Multa;
import com.abcsoft.gestionmultas.services.impl.MultaServicesImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Multa> multas;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listview = (ListView) findViewById(R.id.idListView);
        listview = findViewById(R.id.idListView);
        multas = MultaServicesImpl.getInstance().getAll();

        //MultasAdapter multasAdapter = new MultasAdapter(this,multas);
        listview.setAdapter(new MultasAdapter(this, multas));

    }

    public void nueva(View view){
        //Instanciamos un intent
        Intent intent = new Intent(this, FormularioNuevaMulta.class);

        //Cambiamos de activity
        startActivity(intent);
    }


}
