package com.duongkk.drweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.duongkk.drweather.apis.ApiUtils;
import com.duongkk.drweather.interfaces.ApiCallback;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new ReadJsonTask().execute("");


        ApiCallback callback = ApiUtils.getRootApi().create(ApiCallback.class);
        Map<String,String> params = new HashMap<>();
//        ?order=desc&sort=activity&tagged=Android&site=stackoverflow
//                params.put("order","desc");
//        params.
//        Call<JsonRespone> jsonCallBack = callback.jsonCallBackWithParam(new );
//          jsonCallBack.enqueue(new Callback<JsonRespone>() {
//              @Override
//              public void onResponse(Call<JsonRespone> call, Response<JsonRespone> response) {
//                  Log.d("re",response.body().toString());
//              }
//              @Override
//              public void onFailure(Call<JsonRespone> call, Throwable t) {
//                Log.e("err",t.getMessage());
//                  t.printStackTrace();
//              }
//          });



    }


}
