package com.duongkk.drweather.models;

/**
 * Created by MyPC on 9/9/2016.
 */
public class JsonRespone {
    boolean has_more;
    int quota_max;
    int quota_remaining;

    public JsonRespone(){};

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public int getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(int quota_max) {
        this.quota_max = quota_max;
    }

    public int getQuota_remaining() {
        return quota_remaining;
    }

    public void setQuota_remaining(int quota_remaining) {
        this.quota_remaining = quota_remaining;
    }

    @Override
    public String toString() {
        return "JsonRespone{" +
                "has_more=" + has_more +
                ", quota_max=" + quota_max +
                ", quota_remaining=" + quota_remaining +
                '}';
    }
}
