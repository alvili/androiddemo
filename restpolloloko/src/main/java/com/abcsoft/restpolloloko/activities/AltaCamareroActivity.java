package com.abcsoft.restpolloloko.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abcsoft.restpolloloko.R;
import com.abcsoft.restpolloloko.model.Camarero;
import com.abcsoft.restpolloloko.retrofit.CamareroAPI;
import com.abcsoft.restpolloloko.services.Utilidades;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AltaCamareroActivity extends AppCompatActivity {

        private String nombre;
        private Integer codigo;

        private CamareroAPI jsonPlaceHolderApi;
        private Utilidades ut = new Utilidades();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_alta_camarero);

            TextView textViewNombre = (TextView) findViewById(R.id.id_edit_CamareroName);
            TextView textViewCodigo = (TextView) findViewById(R.id.id_edit_CamareroCode);
            Button buttonCrear = (Button) findViewById(R.id.id_button_CamareroCrear);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://pedi-gest.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            jsonPlaceHolderApi = retrofit.create(CamareroAPI.class);

            //Creo al nuevo camarero con valores aleatorios
            nombre = ut.nombreAleatorio(1000000);
            codigo = Integer.parseInt(ut.nombreAleatorio(1000000));

            textViewNombre.setText(nombre);
            textViewCodigo.setText(String.valueOf(codigo));

            buttonCrear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createCamarero();

                    //Torno a la llista
                    Intent intent = new Intent(v.getContext(), ListadoCamarerosActivity.class);
                    v.getContext().startActivity(intent);
                }
            });

        }

        private void createCamarero(){

            Camarero camarero = new Camarero();
            camarero.setNombre(nombre);
            camarero.setCodigo(codigo);

            Call<Camarero> call = jsonPlaceHolderApi.createCamarero(camarero);

            call.enqueue(new Callback<Camarero>() {

                @Override
                public void onResponse(Call<Camarero> call, Response<Camarero> response) {

                    if (!response.isSuccessful()){
                        return;
                    }

                    Camarero camarero = response.body();
                    return;

                }

                @Override
                public void onFailure(Call<Camarero> call, Throwable t) {
                }
            });

        }



}
