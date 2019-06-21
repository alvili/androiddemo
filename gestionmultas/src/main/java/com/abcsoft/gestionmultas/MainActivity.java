package com.abcsoft.gestionmultas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.abcsoft.gestionmultas.model.Multa;
import com.abcsoft.gestionmultas.services.MultaServices;
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


        /*
        // getInstance es un método estático que nos devuelve LA instancia
        // Utilizo el artículo LA para que se vea claro que hablamos de un singloton

        //MultaServices ms1 = MultaServicesImpl.getInstance();
        // MultaServices ms2 = MultaServicesImpl.getInstance();
        //MultaServices ms3 = MultaServicesImpl.getInstance();
        //MultaServices ms4 = MultaServicesImpl.getInstance();

        //Log.d("*****", "ms1 == ms2 " + (ms1 == ms2)); // TRUE!!!


        MultaServices multaServices = MultaServicesImpl.getInstance();

        multas = multaServices.getAll();
*/

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
