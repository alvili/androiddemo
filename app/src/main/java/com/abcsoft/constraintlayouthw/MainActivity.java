package com.abcsoft.constraintlayouthw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static{
        Log.d("INFO","SE INICIALIZA EL 'MUNDO ESTATICO'");
    }

    long goodbyeTime = System.currentTimeMillis();
    private TextView txtTime;
    private Date fecha =new Date();

    public MainActivity(){
        Log.d("INFO","DENTRO DEL CONSTRUCTOR");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("INFO","DENTRO DE ONCREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTime = (TextView) findViewById(R.id.idTextViewTime);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("INFO","DENTRO DE ONPAUSE");
        fecha = new Date();
        goodbyeTime = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("INFO","DENTRO DE ONRESUME");

        long milisegundos = (new Date()).getTime() - fecha.getTime();
        StringBuilder sb = new StringBuilder();
        sb.append(milisegundos/1000).append(" segundos transcuridos");
        txtTime.setText(sb.toString());

//        txtTime.setText(String.valueOf((System.currentTimeMillis() - goodbyeTime) / 1000));

    }
}
