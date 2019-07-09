package com.abcsoft.restpolloloko.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.model.Producto;
import com.abcsoft.restpolloloko.retrofit.ProductoAPI;
import com.abcsoft.restpolloloko.retrofit.RetrofitHelper;
import com.abcsoft.restpolloloko.services.Utilidades;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AltaProductoActivity  extends AppCompatActivity {

    private ProductoAPI jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_producto);

        TextView textViewNombre = (TextView) findViewById(R.id.id_edit_ProductoName);
        TextView textViewCodigo = (TextView) findViewById(R.id.id_edit_ProductoCode);
        Button buttonCrear = (Button) findViewById(R.id.id_button_ProductoCrear);

        jsonPlaceHolderApi = RetrofitHelper.getProductoAPI();
        //Creo al nuevo camarero con valores aleatorios
//            final String nombre = "ut.nombreAleatorio(1000000);
        final Integer codigo = Integer.parseInt(Utilidades.nombreAleatorio(1000000000));

//        textViewNombre.setText(nombre);
        textViewCodigo.setText(String.valueOf(codigo));

        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto producto = new Producto();
                producto.setNombre("producto_" + String.valueOf(codigo));
                producto.setCodigo(codigo);
                producto.setDescripcion("descripcion_" + String.valueOf(codigo));
                producto.setFechaAlta(new Date());
                producto.setDescatalogado(false);
                producto.setPrecio(Double.parseDouble(Utilidades.nombreAleatorio(1000)));
                producto.setCategoria("POSTRE");

                createProducto(producto);
            }
        });

    }

    private void createProducto(Producto newProducto){

        Call<Producto> call = jsonPlaceHolderApi.create(newProducto);

        call.enqueue(new Callback<Producto>() {

            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if (!response.isSuccessful()){
                    return;
                }
                //Torno a la llista
                Intent intent = new Intent(AltaProductoActivity.this, ListadoProductosActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {

            }
        });

    }



}
