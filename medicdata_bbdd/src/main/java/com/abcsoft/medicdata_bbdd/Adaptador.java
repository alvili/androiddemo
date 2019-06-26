package com.abcsoft.medicdata_bbdd;

import com.abcsoft.medicdata.R;
import com.abcsoft.medicdata_bbdd.model.Lectura;
import com.abcsoft.medicdata_bbdd.model.LecturaServicesImpl;
import com.abcsoft.medicdata_bbdd.model.LecturaServicesSQLite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class Adaptador extends BaseAdapter {

    private LayoutInflater inflater = null;
    private List<Lectura> lecturas;
    private List<Lectura> lecturas2;
    private Context contexto;


    public Adaptador(Context contexto){
        this.contexto=contexto;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        lecturas = LecturaServicesImpl.getInstance().getAll();
        lecturas2 = new LecturaServicesSQLite(this);

        //Guardo leas lecturas a la bbdd
        for (Lectura lectura : lecturas){
            lecturas2.create(lectura);
        }

    }

    @Override
    public int getCount() {
        return lecturas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.lectura_row, null);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

        //Recoger todas las vistas de ese layout

        TextView diastolica = (TextView) vista.findViewById(R.id.idDiastolica);
        TextView sistolica = (TextView) vista.findViewById(R.id.idSistolica);
        TextView peso = (TextView) vista.findViewById(R.id.idPeso);
        TextView fecha = (TextView) vista.findViewById(R.id.idFecha);
        TextView hora = (TextView) vista.findViewById(R.id.idHora);

        Lectura lectura = lecturas.get(position);

        diastolica.setText(String.valueOf(lectura.getDiastolica()));
        sistolica.setText(String.valueOf(lectura.getSistolica()));
        peso.setText(String.valueOf(lectura.getPeso()) + " " + contexto.getString(R.string.weightUnit));
        fecha.setText(sdf1.format(lectura.getFechaHora()));
        hora.setText(sdf2.format(lectura.getFechaHora()));


        return vista;
    }
}
