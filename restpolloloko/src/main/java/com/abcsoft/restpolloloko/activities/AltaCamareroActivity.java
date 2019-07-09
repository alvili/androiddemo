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
import com.abcsoft.restpolloloko.retrofit.RetrofitHelper;
import com.abcsoft.restpolloloko.services.Utilidades;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AltaCamareroActivity extends AppCompatActivity {

        private CamareroAPI jsonPlaceHolderApi;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_alta_camarero);

            TextView textViewNombre = (TextView) findViewById(R.id.id_edit_CamareroName);
            TextView textViewCodigo = (TextView) findViewById(R.id.id_edit_CamareroCode);
            Button buttonCrear = (Button) findViewById(R.id.id_button_CamareroCrear);

            jsonPlaceHolderApi = RetrofitHelper.getCamareroAPI();

            //Creo al nuevo camarero con valores aleatorios
//            final String nombre = "ut.nombreAleatorio(1000000);
            final Integer codigo = Integer.parseInt(Utilidades.nombreAleatorio(1000000));
            final String nombre = "#02_" + String.valueOf(codigo);

            textViewNombre.setText(nombre);
            textViewCodigo.setText(String.valueOf(codigo));

            buttonCrear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Camarero camarero = new Camarero();
                    camarero.setNombre(nombre);
                    camarero.setCodigo(codigo);

                    createCamarero(camarero);
                }
            });

        }

        private void createCamarero(Camarero newCamarero){

            Call<Camarero> call = jsonPlaceHolderApi.create(newCamarero);

            call.enqueue(new Callback<Camarero>() {

                @Override
                public void onResponse(Call<Camarero> call, Response<Camarero> response) {
                    if (!response.isSuccessful()){
                        return;
                    }
                    //Torno a la llista
                    Intent intent = new Intent(AltaCamareroActivity.this, ListadoCamarerosActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<Camarero> call, Throwable t) {

                }
            });

        }

}
