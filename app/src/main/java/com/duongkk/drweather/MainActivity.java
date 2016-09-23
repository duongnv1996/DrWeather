package com.duongkk.drweather;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.duongkk.drweather.Utils.Constants;
import com.duongkk.drweather.Utils.ProgressDialogCustom;
import com.duongkk.drweather.apis.ApiUtils;
import com.duongkk.drweather.interfaces.ApiCallback;
import com.duongkk.drweather.models.JsonRespone;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_temp)
    TextView tvTemp;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_description)
    TextView tvDes;
    @BindView(R.id.tv_min_max_temp)
    TextView tvMinMaxTemp;
    ImageView imgToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tvTemp = (TextView)findViewById(R.id.tv_temp);
        tvCity = (TextView)findViewById(R.id.tv_city);
        tvDes = (TextView)findViewById(R.id.tv_description);
        tvMinMaxTemp=(TextView)findViewById(R.id.tv_min_max_temp);
        imgToday = (ImageView)findViewById(R.id.img_today);
        ApiCallback callback = ApiUtils.getRootApi().create(ApiCallback.class);
        final ProgressDialogCustom dialogCustom= new ProgressDialogCustom(this);
        dialogCustom.showDialog();
        final Call<JsonRespone> responeCall = callback.getWeather("1581130",getString(R.string.api_key),"metric");
        responeCall.enqueue(new Callback<JsonRespone>() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(Call<JsonRespone> call, Response<JsonRespone> response) {
                dialogCustom.hideDialog();
                if(response.isSuccessful()){
                    Log.d("Response : ",response.body().getMain().getTemp()+"");
                    tvCity.setText(response.body().getName());
                    tvTemp.setText(Math.round(response.body().getMain().getTemp())+getString(R.string.temp));
                    tvDes.setText(response.body().getWeather().get(0).getDescription());
                    tvMinMaxTemp.setText(String.format(getString(R.string.min_max_temp),Math.round(response.body().getMain().getTemp_min()),Math.round(response.body().getMain().getTemp_max())));
                    Glide.with(MainActivity.this).load(Constants.URL_ICON+response.body().getWeather().get(0).getIcon()+".png").into(imgToday).onLoadFailed(null,getDrawable(R.drawable.sunny));
                    //Picasso.with(getBaseContext()).load(Constants.URL_ICON+response.body().getWeather().get(0).getIcon()).into(imgToday);
                }
            }

            @Override
            public void onFailure(Call<JsonRespone> call, Throwable t) {
                dialogCustom.hideDialog();
                Log.e("error",t.getMessage());
            }
        });


    }


}
