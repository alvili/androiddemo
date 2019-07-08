package com.abcsoft.restpolloloko.services;                                                                                                                                            package com.abcsoft.restpolloloko.services;

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


//    private void registerTypeAdapter(GsonBuilder builder) {

       // GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                long milliseconds = json.getAsJsonPrimitive().getAsLong();
                return new Date(milliseconds);
            }
        });

        builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {

            @Override
            public JsonElement serialize(Date date, Type typeOfT, JsonSerializationContext context) {
                long milliseconds = date.getTime();
                return new JsonPrimitive(milliseconds);
            }
        });

        Gson gson = builder.create();

        //Retrofit retrofit = new Retrofit.builder()


