package com.abcsoft.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VisorTexto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_texto);


        //TODO
        /*
        ImageView imagen = (ImageView) findViewById(R.id.idImagenGrande);

        //Recogemos los datos enviados por el intent i usarlos para mostrar la imagen

        Intent intent = getIntent();

        //Los datos extra llegan a través de un Bundle
        Bundle b = intent.getExtras(); //Recuperamos lo que hemos preparado con putExtras

        //Solo si bundle no es null
        if(b != null){
            imagen.setImageResource(b.getInt("IMG"));
        }
*/



    }
}
