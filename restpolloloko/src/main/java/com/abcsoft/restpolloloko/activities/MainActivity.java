package com.abcsoft.restpolloloko.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.abcsoft.restpolloloko.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonCamareros;
    Button botonProductos;
    Button botonPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCamareros = findViewById(R.id.button1);
        botonProductos = findViewById(R.id.button2);
        botonPedidos = findViewById(R.id.button3);
        botonCamareros.setOnClickListener(this);
        botonProductos.setOnClickListener(this);
        botonPedidos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;
        switch ((String) v.getTag()){

            case "1": intent = new Intent(this, ListadoCamarerosActivity.class);
                    break;
            case "2": intent = new Intent(this, ListadoProductosActivity.class);
                break;
            case "3": intent = new Intent(this, ListadoPedidosActivity.class);
                break;
        }
        startActivity(intent);
    }
}
