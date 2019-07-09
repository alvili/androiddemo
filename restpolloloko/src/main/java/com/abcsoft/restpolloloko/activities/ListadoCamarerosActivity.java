package com.abcsoft.restpolloloko.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.model.Camarero;
import com.abcsoft.restpolloloko.retrofit.CamareroAPI;
import com.abcsoft.restpolloloko.retrofit.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoCamarerosActivity extends AppCompatActivity {

    private TextView textViewResult;
    private CamareroAPI jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_camareros);

        textViewResult = (TextView) findViewById(R.id.text_view_camareros);

        jsonPlaceHolderApi = RetrofitHelper.getCamareroAPI();

        getCamareros();

    }

    private void getCamareros(){

        Call<List<Camarero>> call = jsonPlaceHolderApi.getAll();

        call.enqueue(new Callback<List<Camarero>>() {

            @Override
            public void onResponse(Call<List<Camarero>> call, Response<List<Camarero>> response) {

                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Camarero> camareros = response.body();

                for(Camarero camarero: camareros){
                    String content = "";
                    content += "Nombre: " + camarero.getNombre() + "\n";
                    content += "Codigo: " + camarero.getCodigo() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Camarero>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

}
