package com.abcsoft.restpolloloko.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.model.Pedido;
import com.abcsoft.restpolloloko.services.Utilidades;

import java.util.List;

public class PedidoListAdapter extends BaseAdapter {

    private LayoutInflater inflater = null;
    private List<Pedido> pedidos;
    private Context contexto;

    public PedidoListAdapter(Context contexto, List<Pedido> pedidos) {
        this.inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        this.pedidos = pedidos;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return pedidos.size();
    }

    @Override
    public Object getItem(int position) {
        return pedidos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) pedidos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.row_model_producto,null);

        TextView id = view.findViewById(R.id.id_textview_pedido_id);
        TextView camarero = view.findViewById(R.id.id_textview_pedido_camarero);
        TextView mesa = view.findViewById(R.id.id_textview_pedido_mesa);
        TextView fecha = view.findViewById(R.id.id_textview_pedido_fecha);
        ListView lineasPedido = (ListView) view.findViewById(R.id.idMiLista);

        id.setText(String.valueOf(pedidos.get(position).getId()));
        camarero.setText(pedidos.get(position).getCamarero().getNombre());
        mesa.setText(pedidos.get(position).getMesa());
        fecha.setText(Utilidades.getStringFromDate(pedidos.get(position).getFecha()));

        lineasPedido.setAdapter(new LineaPedidoListAdapter( getApplicationContext(), pedidos.get(position).getLineasPedido()));

        return view;
    }
}
