package com.duongkk.drweather.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 8/12/2016.
 */
public class ApiUtils {
    public static Retrofit getRootApi(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.stackexchange.com/2.2/").addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
