package com.duongkk.drweather.models;

/**
 * Created by MyPC on 9/23/2016.
 */

public class Main {
    double temp;
    double temp_min;
    double temp_max;

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = Math.round(temp_max);
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = Math.round(temp_min);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = Math.round(temp);
    }
}
