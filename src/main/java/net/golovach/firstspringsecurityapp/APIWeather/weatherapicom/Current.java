package net.golovach.firstspringsecurityapp.APIWeather.weatherapicom;

public class Current {
    private float temp_c;
    private Condition condition;
    private float wind_kph;
    private float pressure_in;


    public Current() {
    }

    public float getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(float temp_c) {
        this.temp_c = temp_c;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public float getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(float wind_kph) {
        this.wind_kph = wind_kph;
    }

    public float getPressure_in() {
        return pressure_in;
    }

    public void setPressure_in(float pressure_in) {
        this.pressure_in = (float) (pressure_in*25.4);
    }

}
