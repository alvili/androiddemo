package com.abcsoft.medicdata.adapters;

import com.abcsoft.medicdata.R;
import com.abcsoft.medicdata.model.Lectura;
import com.abcsoft.medicdata.services.LecturaServices;
import com.abcsoft.medicdata.services.impl.LecturaServicesImpl;
import com.abcsoft.medicdata.services.impl.LecturaServicesSQLite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class Adaptador extends BaseAdapter {

    private static final SimpleDateFormat SDF_FECHA = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat SDF_HORA = new SimpleDateFormat("HH:mm");

    private LayoutInflater inflater = null;
    private List<Lectura> lecturas;
    private Context contexto;


    public Adaptador(Context contexto){
        this.contexto = contexto;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

//        lecturas = LecturaServicesImpl.getInstance().getAll();

        LecturaServices lecturaServices = new LecturaServicesSQLite(contexto);
        lecturas = lecturaServices.getAll();
    }

    @Override
    public int getCount() {
        return lecturas.size();
    }

    @Override
    public Object getItem(int position) {
        return lecturas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lecturas.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.lectura_row, null);

        //Recoger todas las vistas de ese layout
        TextView diastolica = (TextView) vista.findViewById(R.id.idDiastolica);
        TextView sistolica = (TextView) vista.findViewById(R.id.idSistolica);
        TextView peso = (TextView) vista.findViewById(R.id.idPeso);
        TextView fecha = (TextView) vista.findViewById(R.id.idFecha);
        TextView hora = (TextView) vista.findViewById(R.id.idHora);

        //Recupero les dades
        Lectura lectura = lecturas.get(position);

        //Pinto les dades
        diastolica.setText(String.valueOf(lectura.getDiastolica()));
        sistolica.setText(String.valueOf(lectura.getSistolica()));
        peso.setText(String.valueOf(lectura.getPeso()) + " " + contexto.getString(R.string.weightUnit));
        fecha.setText(SDF_FECHA.format(lectura.getFechaHora()));
        hora.setText(SDF_HORA.format(lectura.getFechaHora()));

        return vista;
    }
}
