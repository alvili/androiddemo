package com.abcsoft.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] valores = {"Pepín","Honorio","Carlota","Tatiana","Borja","Fede","Mariano","Paco","Lucia","Alfonso","Gabriel","Honorato","Pepa","Angela","Carolina","Guillermo","Juan","Pepe"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.idListView);

        //Necesitamos un adaptador
        //requiere 3 parametros
        //1. el contexto -> this
        //2. el tipo de gráfico o cómo se va a ver ->  android.R.layout.simple_expandable_list_item_1
        //3. el array de strings

        //usaremos un adaptador de arrays

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, valores);
        //En java 7 no es necesario repetir el tipo
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, valores);
        listView.setAdapter(adapter);

        //TODO Añadimos un listener


//        AdapterView.OnClickListener erListener = new AdapterView.OnClickListener() {});


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //Los parametros se los pasara el listener
            //Necesita saber su padre, la vista, posicion
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String texto = "position: " + position + "Nombre: " + valores[position]
                        + " id: " + " view: " + view.getClass().getSimpleName()
                        + " parent: " + parent.getClass().getSimpleName();
                Toast.makeText(getApplicationContext(),texto, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
