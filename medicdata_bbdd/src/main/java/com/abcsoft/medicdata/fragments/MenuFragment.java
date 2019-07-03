package com.abcsoft.medicdata.fragments;

//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.abcsoft.medicdata.R;


public class MenuFragment extends Fragment {

    private final int[] BOTONES_MENU={R.id.boton1, R.id.boton2, R.id.boton3};

    public MenuFragment() {
        // Required empty public constructor
    }

    // Bundle nos permite pasar o ricibir datos de un sitio a otro

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Se genera la View a partir del xml
        View myMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        //Declaro un ImageButton
        //Iteramos todos los botones y en cada vuelta del for añadimos un listener al botón de turno (botonMenu)
        ImageButton botonMenu;

        // para cada botón...
        for(int i = 0; i < BOTONES_MENU.length; i++){

            // almacenamos en botonMenu todos y cada unos de los botones...
            botonMenu = (ImageButton) myMenu.findViewById(BOTONES_MENU[i]);
            final int BOTON_i = i; // Tiene que ser una constante porque la vamos a utilizar en un listener...

            // Añadimos un listener a cada uno de los botones...
            botonMenu.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Fragment fragment = null;

                    switch (BOTON_i){
                        case 0: fragment = new ListFragment();
                            break;
                        case 1: fragment = new FormLecturaFragment();
                            break;
                        case 2: fragment = new FormUsuarioFragment();
                            break;
                    }

                    //Cambio de fragment
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.destino, fragment).commit();
                }
            });
        }
        return myMenu;
    }

}
