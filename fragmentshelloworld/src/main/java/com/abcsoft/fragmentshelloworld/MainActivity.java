package com.abcsoft.fragmentshelloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abcsoft.fragmentshelloworld.fragments.ComunicaMenu;

public class MainActivity extends AppCompatActivity implements ComunicaMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void menu(int botonPulsado) {

        //Estamos en MainActivity y nos largamos a Destactivity mediante un Intent
        Intent intent = new Intent(this, DestActivity.class);

        //A DestActivity le pasamos info del boton que se ha pulsado: 0, 1 o 2
        intent.putExtra("BOTON_PULSADO", botonPulsado); //Etiqueta - valor

        //Cambio de activity
        startActivity(intent);
    }


}
