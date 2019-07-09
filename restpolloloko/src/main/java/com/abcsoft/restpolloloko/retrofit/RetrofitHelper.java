package com.abcsoft.restpolloloko.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    //private static final CamareroAPI JSON_PLACE_HOLDER_API;
    //private static final CamareroAPI camareroAPI;
    private static final String REST_URL = "https://pedi-gest.herokuapp.com/";
    private static final Retrofit retrofit;

    static {
        // Propuesta de StackOverflow
//
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//                .create();

//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint(API_BASE_URL)
//                .setConverter(new GsonConverter.create(gson))
//                .build();

        //Defino adaptadores de tipo
        GsonBuilder gsonbuilder = new GsonBuilder();

        gsonbuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                //Recupero el valor como long
                long milliseconds = json.getAsJsonPrimitive().getAsLong();
                //Lo convierto a date
                return new Date(milliseconds);
            }
        });

        gsonbuilder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.getTime());
            }
        });

        Gson gson = gsonbuilder.create();

        retrofit = new Retrofit.Builder()
                .baseUrl(REST_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //jsonPlaceHolderApi = retrofit.create(ProductoAPI.class);
    }

    private RetrofitHelper(){

    }

    public static CamareroAPI getCamareroAPI() {
        return retrofit.create(CamareroAPI.class);
    }

    public static ProductoAPI getProductoAPI() {
        return retrofit.create(ProductoAPI.class);
    }

    public static PedidosAPI getPedidosAPI() {
        return retrofit.create(PedidosAPI.class);
    }
}
