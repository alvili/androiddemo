package com.abcsoft.restpolloloko.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.adapters.CamareroListAdapter;
import com.abcsoft.restpolloloko.adapters.PedidoListAdapter;
import com.abcsoft.restpolloloko.adapters.ProductoListAdapter;
import com.abcsoft.restpolloloko.model.Camarero;
import com.abcsoft.restpolloloko.model.Pedido;
import com.abcsoft.restpolloloko.model.Producto;
import com.abcsoft.restpolloloko.retrofit.CamareroAPI;
import com.abcsoft.restpolloloko.retrofit.PedidosAPI;
import com.abcsoft.restpolloloko.retrofit.ProductoAPI;
import com.abcsoft.restpolloloko.retrofit.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewActivity extends AppCompatActivity {

    private ListView lista;
    private CamareroAPI jsonPlaceHolderApi_camarero;
    private ProductoAPI jsonPlaceHolderApi_producto;
    private PedidosAPI jsonPlaceHolderApi_pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lista = (ListView) findViewById(R.id.idMiLista);

        jsonPlaceHolderApi_camarero = RetrofitHelper.getCamareroAPI();
        jsonPlaceHolderApi_producto = RetrofitHelper.getProductoAPI();
        jsonPlaceHolderApi_pedido = RetrofitHelper.getPedidosAPI();

        //Recupero los datos enviados con el cambio de activity
        Intent intent = getIntent();
        Bundle b = intent.getExtras(); //Los datos extra llegan a través de un Bundle y se añaden mediante putExtras

        //Solo si bundle no e
        switch ((String) b.getString("accion")) {
            case "camareros":
                getCamareros();
                break;
            case "productos":
                getProductos();
                break;
            case "pedidoss":
                getPedidos();
                break;

        }

    }

    private void getCamareros(){

        Call<List<Camarero>> call = jsonPlaceHolderApi_camarero.getAll();

        call.enqueue(new Callback<List<Camarero>>() {

            @Override
            public void onResponse(Call<List<Camarero>> call, Response<List<Camarero>> response) {

                if (!response.isSuccessful()){
                    //???
                    return;
                }

                //Recupero los datos e inflo la vista
                List<Camarero> camareros = response.body();
                lista.setAdapter(new CamareroListAdapter(getApplicationContext(), camareros));

            }

            @Override
            public void onFailure(Call<List<Camarero>> call, Throwable t) {
                //???
            }
        });

    }

    private void getProductos(){

        Call<List<Producto>> call = jsonPlaceHolderApi_producto.getAll();

        call.enqueue(new Callback<List<Producto>>() {

            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                if (!response.isSuccessful()){
                    //???
                    return;
                }

                //Recupero los datos e inflo la vista
                List<Producto> productos = response.body();
                lista.setAdapter(new ProductoListAdapter(getApplicationContext(), productos));

            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                //???
            }
        });

    }

    private void getPedidos(){

        Call<List<Pedido>> call = jsonPlaceHolderApi_pedido.getAll();

        call.enqueue(new Callback<List<Pedido>>() {

            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {

                if (!response.isSuccessful()){
                    //???
                    return;
                }

                //Recupero los datos e inflo la vista
                List<Pedido> pedidos = response.body();
                lista.setAdapter(new PedidoListAdapter(getApplicationContext(), pedidos));

            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {
                //???
            }
        });

    }


}
