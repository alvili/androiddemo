package com.abcsoft.medicdata_bbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

//import com.abcsoft.medicdata.R;

public class ListActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.idLista);

        //Tenemos que setear a la lista un adaptador
        lista.setAdapter(new Adaptador(this));
    }
}
