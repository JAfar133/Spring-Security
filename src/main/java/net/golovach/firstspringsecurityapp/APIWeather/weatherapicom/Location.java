package net.golovach.firstspringsecurityapp.APIWeather.weatherapicom;


import net.golovach.firstspringsecurityapp.APIWeather.DateFormat;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;




public class Location {
    private String name;
    private String region;
    private String country;
    private float lat;
    private float lon;
    private String tz_id;
    private String localtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getTz_id() {
        return tz_id;
    }

    public void setTz_id(String tz_id) {
        this.tz_id = tz_id;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String strDate) {
        this.localtime = DateFormat.format(strDate);
    }
}
