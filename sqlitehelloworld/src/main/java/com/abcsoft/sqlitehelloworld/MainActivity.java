package com.abcsoft.sqlitehelloworld;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    EditText et1;
    EditText et2;
    EditText et3;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mapeo los elementos del formulario
        et1 = (EditText) findViewById(R.id.idTexto1);
        et2 = (EditText) findViewById(R.id.idTexto2);
        et3 = (EditText) findViewById(R.id.idTexto3);
        b1 = (Button) findViewById(R.id.idBoton1);
        b2 = (Button) findViewById(R.id.idBoton2);

        //Creo la bbdd
        myDB= new DatabaseHelper(this);

        //Añado listeners
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nombre = et1.getText().toString();
                String apellido1 = et2.getText().toString();
                String apellido2 = et3.getText().toString();

                //Creamos un amigo..
                Toast.makeText(MainActivity.this, apellido1+" "+apellido2+" "+nombre, Toast.LENGTH_LONG).show();

                myDB.insertData(nombre,apellido1,apellido2);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Cursor cursor = myDB.getAll();

                if(cursor == null || cursor.getCount() == 0 ) {
                    //Si vacio, no hay nada que hacer
                    return;
                }

                //Recupero los campos
                while (cursor.moveToNext()){
                    int codigo = cursor.getInt(0);
                    //String nombre = cursor.getString(cursor.getColumnIndex("Nombre"));
                    String nombre = cursor.getString(1);
                    String apellido1 = cursor.getString(2);
                    String apellido2 = cursor.getString(3);

                    String dato = codigo + " " + nombre + " " + apellido1 + " " + apellido2;
                    Log.d("******", dato);
                }
            }
        });

    }
}
