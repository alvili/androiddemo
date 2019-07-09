package com.abcsoft.restpolloloko.retrofit;

import com.abcsoft.restpolloloko.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ProductoAPI {

    @GET("api/productos")
    Call<List<Producto>> getAll();

    @Headers("Content-type: application/json")
    @POST("api/productos")
    Call<Producto> create(@Body Producto producto);


}
