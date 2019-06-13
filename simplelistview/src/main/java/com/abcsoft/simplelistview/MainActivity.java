package com.abcsoft.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] valores = {"Pepín","Honorio","Carlota","Tatiana","Borja","Fede","Mariano","Paco","Lucia","Alfonso","Gabriel","Honorato","Pepa","Angela","Carolina","Guillermo","Juan","Pepe"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.idListView);

        //Necesitamos un adaptador
        //3 parametros
        //1. el contexto -> this
        //2. el tipo de gráfico o cómo se va a ver ->  android.R.layout.simple_expandable_list_item_1
        //3. el array de strings
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, valores);
        //En java 7 no es necesario repetir el tipo
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, valores);
        listView.setAdapter(adapter);

    }
}
