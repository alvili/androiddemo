package com.abcsoft.banderas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    //Arrays de datos
    private String [][] datos = {
            {"Argentina", "South America"},
            {"Belgium", "Europe"},
            {"Canada", "North America"},
            {"Switzerland", "Europe"},
            {"The People's Republic Of China", "Asia"},
            {"Egypt", "Africa"},
            {"Spain", "Europe"},
            {"The United Kingdom", "Europe"},
            {"Greece", "Europe"},
            {"Iceland", "Europe"},
            {"Italy", "Europe"},
            {"Japan", "Asia"},
            {"South Korea", "Asia"},
            {"Mexico", "North America"},
            {"Norway", "Europe"},
            {"New Zealand", "Oceania"},
            {"Russia", "Europe"},
            {"Thailand", "Asia"},
            {"USA", "north America"},
            {"Australia", "Oceania"}
    };

    private int[] datosImg = {
            R.drawable.ar,
            R.drawable.be,
            R.drawable.ca,
            R.drawable.ch,
            R.drawable.cn,
            R.drawable.eg,
            R.drawable.es,
            R.drawable.gb,
            R.drawable.gr,
            R.drawable.is,
            R.drawable.it,
            R.drawable.jp,
            R.drawable.kr,
            R.drawable.mx,
            R.drawable.no,
            R.drawable.nz,
            R.drawable.ru,
            R.drawable.th,
            R.drawable.us,
            R.drawable.au
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.idListview);
        listview.setAdapter(new Adapter(this, datos, datosImg));
    }
}
