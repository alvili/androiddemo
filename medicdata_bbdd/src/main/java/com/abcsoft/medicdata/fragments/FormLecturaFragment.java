package com.abcsoft.medicdata.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.abcsoft.medicdata.R;
import com.abcsoft.medicdata.model.Lectura;
import com.abcsoft.medicdata.model.LecturaServices;
import com.abcsoft.medicdata.model.LecturaServicesSQLite;

import java.util.Date;

public class FormLecturaFragment extends Fragment {

    private LecturaServices lecturaServices;
    EditText editPeso;
    EditText editDiastolica;
    EditText editSistolica;

    public FormLecturaFragment() {
        //lecturaServices = LecturaServicesImpl.getInstance();
        lecturaServices = new LecturaServicesSQLite(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View MyView = inflater.inflate(R.layout.fragment_form_lectura, container, false);
        EditText editPeso = (EditText) MyView.findViewById(R.id.idEntradaPeso);
        EditText editDiastolica = (EditText) MyView.findViewById(R.id.idEntradaDiastolica);
        EditText editSistolica = (EditText) MyView.findViewById(R.id.idEntradaSistolica);

        return MyView;
    }


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

}
