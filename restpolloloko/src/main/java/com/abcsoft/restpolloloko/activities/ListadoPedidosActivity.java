package com.abcsoft.restpolloloko.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.model.Pedido;
import com.abcsoft.restpolloloko.model.Producto;
import com.abcsoft.restpolloloko.retrofit.JsonPlaceHolderApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoPedidosActivity extends AppCompatActivity {

    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pedidos);

        textViewResult = (TextView) findViewById(R.id.text_view_pedidos);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pedi-gest.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getPedidos();

    }

    private void getPedidos(){

        Call<List<Pedido>> call = jsonPlaceHolderApi.getPedidos();

        call.enqueue(new Callback<List<Pedido>>() {

            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {

                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Pedido> pedidos = response.body();

                for(Pedido pedido: pedidos){
                    String content = "";
                    content += "Camarero: " + pedido.getCamarero().getNombre() + "\n";
                    content += "Mesa: " + pedido.getMesa() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }



}
