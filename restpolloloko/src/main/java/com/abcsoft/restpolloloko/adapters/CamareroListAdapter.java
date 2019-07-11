package com.abcsoft.restpolloloko.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.model.Camarero;

import java.util.List;

public class CamareroListAdapter extends BaseAdapter {

    private LayoutInflater inflater = null;
    private List<Camarero> camareros;
    private Context contexto;


    public CamareroListAdapter(Context contexto, List<Camarero> camareros){
        this.contexto = contexto;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        this.camareros = camareros;
    }

    @Override
    public int getCount() {
        return camareros.size();
    }

    @Override
    public Object getItem(int position) {
        return camareros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) camareros.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = inflater.inflate(R.layout.row_model_camarero, null);

        TextView codigo = view.findViewById(R.id.id_textview_camarero_codigo);
        TextView nombre = view.findViewById(R.id.id_textview_camarero_nombre);

        codigo.setText(String.valueOf(camareros.get(position).getCodigo()));
        nombre.setText(camareros.get(position).getNombre());

        return view;
    }
}
