package com.abcsoft.restpolloloko.retrofit;

import com.abcsoft.restpolloloko.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductoAPI {

    @GET("api/productos")
    Call<List<Producto>> getProductos();

}
