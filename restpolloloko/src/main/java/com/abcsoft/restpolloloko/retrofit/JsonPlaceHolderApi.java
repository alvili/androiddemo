package com.abcsoft.restpolloloko.retrofit;

import com.abcsoft.restpolloloko.model.Camarero;
import com.abcsoft.restpolloloko.model.Pedido;
import com.abcsoft.restpolloloko.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("api/pedidos")
    Call<List<Pedido>> getPedidos();

}