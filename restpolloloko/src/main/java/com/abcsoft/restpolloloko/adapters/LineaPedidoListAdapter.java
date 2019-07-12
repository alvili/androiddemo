package com.abcsoft.restpolloloko.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.model.LineaPedido;

import java.util.List;

public class LineaPedidoListAdapter extends BaseAdapter {

    private LayoutInflater inflater = null;
    private List<LineaPedido> lineasPedido;
    private Context contexto;

    public LineaPedidoListAdapter(Context contexto, List<LineaPedido> lineasPedido) {
        this.inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        this.lineasPedido = lineasPedido;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return lineasPedido.size();
    }

    @Override
    public Object getItem(int position) {
        return lineasPedido.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.row_model_lineapedido,null);


        return view;
    }
}
