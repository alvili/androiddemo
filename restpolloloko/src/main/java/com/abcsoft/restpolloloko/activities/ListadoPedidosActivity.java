package com.abcsoft.restpolloloko.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.model.Pedido;
import com.abcsoft.restpolloloko.retrofit.PedidosAPI;
import com.abcsoft.restpolloloko.retrofit.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoPedidosActivity extends AppCompatActivity {

    private TextView textViewResult;
    private PedidosAPI jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pedidos);

        textViewResult = (TextView) findViewById(R.id.text_view_pedidos);

        jsonPlaceHolderApi = RetrofitHelper.getPedidosAPI();

        getPedidos();

    }

    private void getPedidos(){

        Call<List<Pedido>> call = jsonPlaceHolderApi.getAll();

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
