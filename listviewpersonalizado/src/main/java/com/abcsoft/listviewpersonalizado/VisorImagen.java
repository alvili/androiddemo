package com.abcsoft.listviewpersonalizado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class VisorImagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);

        ImageView imagen = (ImageView) findViewById(R.id.idImagenGrande);

        //Recogemos los datos enviados por el intent i usarlos para mostrar la imagen

        Intent intent = getIntent();

        //Los datos extra llegan a través de un Bundle
        Bundle b = intent.getExtras(); //Recuperamos lo que hemos preparado con putExtras

        //Solo si bundle no es null
        if(b != null){
            imagen.setImageResource(b.getInt("IMG"));
        }

    }
}
