package com.duongkk.drweather.interfaces;

import com.duongkk.drweather.models.JsonRespone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by MyPC on 8/12/2016.
 */
public interface ApiCallback {

    @GET("weather")
    Call<JsonRespone> getWeather(@Query("id") String id,
                                 @Query("appid") String appid,
                                 @Query("units") String units);


}
