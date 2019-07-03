package com.abcsoft.medicdata.fragments;

//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.abcsoft.medicdata.adapters.Adaptador;
import com.abcsoft.medicdata.R;

public class ListFragment extends Fragment {

    private ListView lista;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        //You need to inflate the Fragment's view and call findViewById() on the View it returns.
        View myView = inflater.inflate(R.layout.fragment_list, container, false);

        lista = (ListView) myView.findViewById(R.id.idLista);
        //Tenemos que setear a la lista un adaptador
        lista.setAdapter(new Adaptador(getActivity()));

        return myView;

    }

}
