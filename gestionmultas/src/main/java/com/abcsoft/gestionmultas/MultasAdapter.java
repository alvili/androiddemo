package com.abcsoft.gestionmultas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.abcsoft.gestionmultas.model.Multa;

import java.util.List;

public class MultasAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Context contexto;
    private List<Multa> multas;

    public MultasAdapter() {
    }

    public MultasAdapter(Context contexto, List<Multa> multas) {
        this.contexto = contexto;
        this.multas = multas;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return multas.size();
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
    public View getView(int i, View convertView, ViewGroup parent) {
        //Tenemos que crear un objecto a partir del xml

        //Creo un objeto view a partir de la plantilla elemento_lista
        final View view = inflater.inflate(R.layout.multa_row, null);

        //Creo objetos a imagen de la plantilla para llenarlos
        TextView codigo = (TextView) view.findViewById(R.id.idTextViewCodigo);
        TextView importe = (TextView) view.findViewById(R.id.idTextViewImporte);

        codigo.setText(String.valueOf(multas.get(i).getCodigo()));
        importe.setText(String.valueOf(multas.get(i).getImporte()));

        return view;
    }

}
