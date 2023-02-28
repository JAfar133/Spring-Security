package net.golovach.firstspringsecurityapp.APIWeather.weatherapicom;


import net.golovach.firstspringsecurityapp.APIWeather.DateFormat;


public class Hour {
    private String time;
    private float temp_c;
    private float feelslike_c;
    private Condition condition;

    public Hour() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String strDate) {
        this.time = DateFormat.format(strDate);
    }

    public float getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(float temp_c) {
        this.temp_c = temp_c;
    }

    public float getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(float feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
