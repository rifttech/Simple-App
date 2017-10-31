package org.apparatum.simple_app.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arthur Abramov on 29.10.2017.
 */

public class Geo {
    @SerializedName("lat")
    private float lat;
    @SerializedName("lng")
    private float lng;

    public Geo() {
    }

    public Geo(float lat, float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
