package com.abcsoft.constraintlayouthw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    long goodbyeTime=2;
    private TextView txtTime;
    private Date fecha =new Date();

    static{
        Log.d("INFO","SE INICIALIZA EL 'MUNDO ESTATICO'");
    }

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
        goodbyeTime = System.currentTimeMillis();
        Log.d("INFO","DENTRO DE ONPAUSE" + goodbyeTime);
        //fecha = new Date().getTime();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("INFO","DENTRO DE ONRESUME" + goodbyeTime);

//        long milisegundos = (new Date()).getTime() - fecha.getTime();
//        StringBuilder sb = new StringBuilder();
//        sb.append(milisegundos/1000).append(" segundos transcuridos");

        long onPauseTime;
        onPauseTime = System.currentTimeMillis() - goodbyeTime;
        Log.d("INFO", String.valueOf(onPauseTime) );

        txtTime.setText(String.valueOf(onPauseTime));
//        txtTime.setText(sb.toString());

    }
}
