package com.abcsoft.fragmentshelloworld;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abcsoft.fragmentshelloworld.fragments.AFragment;
import com.abcsoft.fragmentshelloworld.fragments.BFragment;
import com.abcsoft.fragmentshelloworld.fragments.CFragment;
import com.abcsoft.fragmentshelloworld.fragments.ComunicaMenu;


public class DestActivity extends AppCompatActivity implements ComunicaMenu {

    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dest);

        fragments = new Fragment[3]; //Creo array de 3 elementos
        fragments[0] = new AFragment();
        fragments[1] = new BFragment();
        fragments[2] = new CFragment();

        //Recojo la info de putExtras, llega la información de boton_pulsado 0, 1 o 2
        Bundle extras = getIntent().getExtras();

        //Invocamos al metodo menu pasando como parametro el boton pulsado
        menu(extras.getInt("BOTON_PULSADO")); //Recuperamos el valor mediante el tag

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
