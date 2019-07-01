package com.abcsoft.fragmentshelloworld.fragments;

import android.app.Fragment; //usamos la libreria deprecada
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abcsoft.fragmentshelloworld.R;

public class AFragment extends Fragment {

    public AFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

}
