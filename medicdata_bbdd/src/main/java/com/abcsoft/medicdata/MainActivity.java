package com.abcsoft.medicdata;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.abcsoft.medicdata.fragments.ComunicaMenu;
import com.abcsoft.medicdata.fragments.FormLecturaFragment;
import com.abcsoft.medicdata.fragments.ListFragment;
import com.abcsoft.medicdata.fragments.FormUsuarioFragment;


public class MainActivity extends AppCompatActivity implements ComunicaMenu {

    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new Fragment[3]; //Creo array de 3 elementos
        fragments[0] = new FormLecturaFragment();
        fragments[1] = new ListFragment();
        fragments[2] = new FormUsuarioFragment();
        menu(1);

//        //Recojo la info de putExtras, llega la información de boton_pulsado 0, 1 o 2
//        Bundle extras = getIntent().getExtras();
//
//        //Invocamos al metodo menu pasando como parametro el boton pulsado
//        menu(extras.getInt("BOTON_PULSADO")); //Recuperamos el valor mediante el tag

    }

    @Override
    public void menu(int BotonPulsado) {

        FragmentManager fragmentManager = getFragmentManager(); // Ojo importarlo bien!
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //??

        // nos pide
        // 1. identificador del contenedor...
        // 2. el fragmento que queremos cargar... hay tres posibilidades.

        //Cambia el contenido de "destino" con el fragmento correspondiente
        fragmentTransaction.replace(R.id.destino, fragments[BotonPulsado]);
        fragmentTransaction.commit();

    }
}
