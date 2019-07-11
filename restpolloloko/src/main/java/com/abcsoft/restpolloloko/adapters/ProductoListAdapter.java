package com.abcsoft.restpolloloko.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.model.Producto;
import com.abcsoft.restpolloloko.services.Utilidades;

import java.util.List;

public class ProductoListAdapter extends BaseAdapter {

    private LayoutInflater inflater = null;
    private List<Producto> productos;
    private Context contexto;


    public ProductoListAdapter(Context contexto, List<Producto> productos){
        this.contexto = contexto;
        this.inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int position) {
        return productos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) productos.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = inflater.inflate(R.layout.row_model_producto, null);

        TextView codigo = view.findViewById(R.id.id_textview_producto_codigo);
        TextView nombre = view.findViewById(R.id.id_textview_producto_nombre);
        TextView categoria = view.findViewById(R.id.id_textview_producto_categoria);
        TextView descripcion = view.findViewById(R.id.id_textview_producto_descripcion);
        TextView fecha = view.findViewById(R.id.id_textview_producto_fecha);
        TextView descatalogado = view.findViewById(R.id.id_textview_producto_descatalogado);
        TextView precio = view.findViewById(R.id.id_textview_producto_precio);

        codigo.setText(String.valueOf(productos.get(position).getCodigo()));
        nombre.setText(productos.get(position).getNombre());
        categoria.setText(productos.get(position).getCategoria());
        descripcion.setText(productos.get(position).getDescripcion());
        fecha.setText(Utilidades.getStringFromDate(productos.get(position).getFechaAlta()));
        descatalogado.setText(String.valueOf(productos.get(position).getDescatalogado()));
        precio.setText(String.valueOf(productos.get(position).getPrecio()) + " €");

        return view;
    }
}
