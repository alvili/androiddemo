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
import android.widget.EditText;

import com.abcsoft.medicdata.R;
import com.abcsoft.medicdata.model.Lectura;
import com.abcsoft.medicdata.services.LecturaServices;
import com.abcsoft.medicdata.services.impl.LecturaServicesSQLite;

import java.util.Date;

public class FormLecturaFragment extends Fragment {

    private LecturaServices lecturaServices;
    private EditText editPeso;
    private EditText editDiastolica;
    private EditText editSistolica;

    public FormLecturaFragment() {
//        lecturaServices = LecturaServicesImpl.getInstance();
//        lecturaServices = new LecturaServicesSQLite(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Instancia a la BBDD
        //lecturaServices = LecturaServicesImpl.getInstance();
        lecturaServices = new LecturaServicesSQLite(getActivity());

        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_form_lectura, container, false);

        editPeso = (EditText) myView.findViewById(R.id.idEntradaPeso);
        editDiastolica = (EditText) myView.findViewById(R.id.idEntradaDiastolica);
        editSistolica = (EditText) myView.findViewById(R.id.idEntradaSistolica);

        //Añado listener para el boton
        myView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                double peso = Double.parseDouble(editPeso.getText().toString());
                double diastolica = Double.parseDouble(editDiastolica.getText().toString());
                double sistolica = Double.parseDouble(editSistolica.getText().toString());

                //Instancio una lectura
                Lectura lectura = new Lectura(new Date(), peso, diastolica, sistolica, 0, 0);

                //Persisto la lectura
                lecturaServices.create(lectura);

                //Cambio del fragment actual al fragment de la lista de lecturas
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                //Cambia el contenido de "destino" con el fragmento correspondiente
                fragmentTransaction.replace(R.id.destino, new ListFragment());
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return myView;
    }

    //MALA PRACTICA. FUNCION PUBLICA ASIGNADA AL EVENTO ONCLICK
/*
    public void enviar(View view){

        double peso = Double.parseDouble(editPeso.getText().toString());
        double diastolica = Double.parseDouble(editDiastolica.getText().toString());
        double sistolica = Double.parseDouble(editSistolica.getText().toString());

        // Vamos a instanciar una lectura...

        Lectura lectura = new Lectura(new Date(), peso, diastolica, sistolica);

        // Vamos a persistir la lectura...
        lecturaServices.create(lectura);

        //Cambio de fragment a la lista de lecturas
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Cambia el contenido de "destino" con el fragmento correspondiente
        fragmentTransaction.replace(R.id.destino, new ListFragment());
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
*/

}
