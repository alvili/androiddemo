package com.abcsoft.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lista;

    //A falta de bbdd o REST, fabrico los datos mediante arrays
    private String [][] datos = {  //Array de arrays
            {"Gato0", "Travieso", "8:29","2", "bla bla bla"},
            {"Gato1", "Familiar", "2:49","9", "bla bla bla"},
            {"Gato2", "Salvaje", "3:39","3", "ble ble ble"},
            {"Gato3", "Domestico", "2:55","5", "bli bli bli"},
            {"Gato4", "Goloso", "2:43","6", "blo blo blo"},
            {"Gato5", "Jugueton", "2:29","2", "bla bla bla"}
    };

    private int[] datosImg = {
            R.drawable.gato0,
            R.drawable.gato1,
            R.drawable.gato2,
            R.drawable.gato3,
            R.drawable.gato4,
            R.drawable.gato5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.idMiLista);

        //En esta clase solo falta una linia de codigo
        lista.setAdapter(new Adaptador(this, datos, datosImg));
    }
}
