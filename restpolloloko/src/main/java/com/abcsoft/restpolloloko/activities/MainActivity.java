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
    Button botonAltaCamareros;
    Button botonAltaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCamareros = findViewById(R.id.button1);
        botonProductos = findViewById(R.id.button2);
        botonPedidos = findViewById(R.id.button3);
        botonAltaCamareros = findViewById(R.id.button4);
        botonAltaProductos = findViewById(R.id.button5);
        botonCamareros.setOnClickListener(this);
        botonProductos.setOnClickListener(this);
        botonPedidos.setOnClickListener(this);
        botonAltaCamareros.setOnClickListener(this);
        botonAltaProductos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        //Disseño con una activity por cada concepto
//        Intent intent = null;
//        switch ((String) v.getTag()){
//
//            case "1": intent = new Intent(this, ListadoCamarerosActivity.class);
//                    break;
//            case "2": intent = new Intent(this, ListadoProductosActivity.class);
//                break;
//            case "3": intent = new Intent(this, ListadoPedidosActivity.class);
//                break;
//            case "4": intent = new Intent(this, AltaCamareroActivity.class);
//                break;
//            case "5": intent = new Intent(this, AltaProductoActivity.class);
//                break;
//        }
//        startActivity(intent);


        //Disseño con una unica activity por todos los conceptos
        Intent intent = null;
        intent = new Intent(this, ListViewActivity.class);
        switch ((String) v.getTag()) {
            case "1":
                intent.putExtra("accion", "camareros");
                break;
            case "2":
                intent.putExtra("accion", "productos");
                break;
            case "3":
                intent.putExtra("accion", "pedidos");
                break;
        }
        startActivity(intent);

    }
}
