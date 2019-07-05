package com.abcsoft.restpolloloko.retrofit;

import com.abcsoft.restpolloloko.model.Camarero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CamareroAPI {

    @GET("api/camareros")
    Call<List<Camarero>> getCamareros();

}
