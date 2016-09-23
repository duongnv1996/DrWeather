package com.duongkk.drweather.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 8/12/2016.
 */
public class Song {

    long id;
    String title;
    Link link_download;


    @SerializedName("artist")
    String casi;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Link getLink_download() {
        return link_download;
    }

    public void setLink_download(Link link_download) {
        this.link_download = link_download;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public class Link{
       // String 128;
        @SerializedName("128")
        String link128 ;

        public String getLink128() {
            return link128;
        }

        public void setLink128(String link128) {
            this.link128 = link128;
        }
    }
}
