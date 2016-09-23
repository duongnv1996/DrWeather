package com.duongkk.drweather.AnsynTaskUtils;

import android.os.AsyncTask;
import android.util.Log;

import com.duongkk.drweather.Utils.Constants;
import com.duongkk.drweather.models.Song;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by MyPC on 8/12/2016.
 */
public class ReadJsonTask extends AsyncTask<String,Void,Void> {
    public ReadJsonTask (){};
    private void LogE(String e){
        Log.e("ReadJsonTask",e);
    }
    @Override
    protected Void doInBackground(String... strings) {
        String url  = strings[0];
        try {
            InputStream inputStream= new URL(Constants.URL_API).openStream();
            StringBuilder responseJson = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
            int count;
            while ((count=bufferedReader.read())!=-1){
                responseJson.append((char)count);
            }
            bufferedReader.close();
            inputStream.close();
            LogE(responseJson.toString());
            //Parse Json
            JSONObject root = new JSONObject(responseJson.toString());
            if(root !=null ){
                if(root.has("title")) {
                    String name = root.getString("title");
                    LogE(name);
                }
                JSONObject linkDownObj = root.getJSONObject("link_download");
                String link128 = linkDownObj.getString("128");
                LogE(link128);
            }
            Song song = new Gson().fromJson(responseJson.toString(),Song.class);
            LogE(song.getTitle()+"-"+song.getId()+"-"+song.getCasi()+"-"+song.getLink_download().getLink128());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
            LogE(e.toString());
        }
        return null;
    }


}
