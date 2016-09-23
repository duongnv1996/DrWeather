package com.duongkk.drweather.interfaces;

import com.duongkk.drweather.models.JsonRespone;
import com.duongkk.drweather.models.Song;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by MyPC on 8/12/2016.
 */
public interface ApiCallback {
    @GET("getsonginfo?requestdata=%7B%22id%22%3A%22{id}0%22%7D")
    Call<Song> songCall (@Query("id") String id);

    @GET("search?order=desc&sort=activity&tagged=Android&site=stackoverflow")
    Call<JsonRespone> jsonCallBack();
    @GET("search")
    Call<JsonRespone> jsonCallBackWithParam(@QueryMap Map<String,String> params);

}
