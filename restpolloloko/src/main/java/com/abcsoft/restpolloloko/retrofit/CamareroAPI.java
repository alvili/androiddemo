package com.abcsoft.restpolloloko.retrofit;

import com.abcsoft.restpolloloko.model.Camarero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CamareroAPI {

    @GET("api/camareros")
    Call<List<Camarero>> getAll();

    @Headers("Content-type: application/json")
    @POST("api/camareros")
    Call <Camarero> create(@Body Camarero camarero);

}