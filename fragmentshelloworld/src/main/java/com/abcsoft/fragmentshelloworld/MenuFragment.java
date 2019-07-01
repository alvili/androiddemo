package com.abcsoft.fragmentshelloworld;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.abcsoft.fragmentshelloworld.fragments.ComunicaMenu;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private final int[] BOTONES_MENU={R.id.boton1, R.id.boton2, R.id.boton3};

    public MenuFragment() {
        // Required empty public constructor
    }

    // Bundle nos permite pasar o ricibir datos de un sitio a otro

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Se genera la vieu a partir del xml
        View miMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        //Declaro un ImageButton
        //Iteramos todos los botones y en cada vuelta del for añadimos un listener al botón de turno (botonMenu)
        ImageButton botonMenu;

        // para cada botón...
        for(int i = 0; i < BOTONES_MENU.length; i++){

            // almacenamos en botonMenu todos y cada unos de los botones...
            botonMenu = (ImageButton) miMenu.findViewById(BOTONES_MENU[i]);

            final int boton = i; // Tiene que ser una constante porque la vamos a utilizar en un listener...

            // Añadimos un listener a cada uno de los botones...
            botonMenu.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // Hemos de detectar en que actividad nos encontramos...
                    Activity actividadActual = getActivity();

                    //Hay que enviar la información al interface ComunicaMenu
                    Log.d("**","pulsamos y enviamos info del boton: " + boton);

                    // Hemos de invocar al método .menu(boton) de la actividad actual.
                    // Pero para ello, la actividad la hemos de tratar como ComunicaMenu
                    // Por eso hacemos el casting...

                    ComunicaMenu cm = (ComunicaMenu) actividadActual;
                    cm.menu(boton);

                }
            });

        }
        return miMenu;

    }
}
