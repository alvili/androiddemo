package com.abcsoft.restpolloloko.retrofit;

import com.abcsoft.restpolloloko.model.Pedido;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PedidosAPI {

    @GET("api/pedidos")
    Call<List<Pedido>> getAll();

}