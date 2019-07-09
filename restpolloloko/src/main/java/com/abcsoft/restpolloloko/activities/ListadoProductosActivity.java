package com.abcsoft.restpolloloko.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.model.Producto;
import com.abcsoft.restpolloloko.retrofit.ProductoAPI;
import com.abcsoft.restpolloloko.retrofit.RetrofitHelper;
import com.abcsoft.restpolloloko.services.Utilidades;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoProductosActivity extends AppCompatActivity {

    private TextView textViewResult;
    private ProductoAPI jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_productos);

        textViewResult = (TextView) findViewById(R.id.text_view_productos);

        jsonPlaceHolderApi = RetrofitHelper.getProductoAPI();

        getProductos();

    }

    private void getProductos(){

        Call<List<Producto>> call = jsonPlaceHolderApi.getAll();

        call.enqueue(new Callback<List<Producto>>() {

            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Producto> productos = response.body();

                for(Producto producto: productos){
                    StringBuilder content = new StringBuilder()
                    .append("Codigo: ").append(producto.getCodigo()).append("\n")
                    .append("Nombre: ").append(producto.getNombre()).append("\n")
                    .append("Categoria: ").append(producto.getCategoria()).append("\n")
                    .append("Descripcion: ").append(producto.getDescripcion()).append("\n")
                    .append("Fecha: ").append(Utilidades.getStringFromDate(producto.getFechaAlta())).append("\n")
                    .append("Descatalogado: ").append(producto.getDescatalogado()).append("\n")
                    .append("Precio: ").append(producto.getPrecio()).append("\n")
                    .append("\n");
//                    DateFormat.getDateTimeInstance().format(new Date(myMillisValue))
//                   .append("Fecha: ").append(DateFormat.getDateTimeInstance().format(new Date(producto.getFechaAlta()))).append("\n")
//
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

}
