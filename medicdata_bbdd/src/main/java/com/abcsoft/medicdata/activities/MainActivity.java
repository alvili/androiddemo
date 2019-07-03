package com.abcsoft.medicdata.activities;


//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
//import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abcsoft.medicdata.R;
import com.abcsoft.medicdata.fragments.FormLecturaFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fuerzo que la actividad aparezca con un fragment siempre por defecto
        // Considero que el menú para introducir la lectura debe aparecer siempre primero
        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.destino, new FormLecturaFragment()).commit();
        }
    }

}
