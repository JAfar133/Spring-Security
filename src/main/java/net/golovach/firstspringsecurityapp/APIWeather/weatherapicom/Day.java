package net.golovach.firstspringsecurityapp.APIWeather.weatherapicom;

public class Day {
    private float maxtemp_c;
    private float mintemp_c;
    private float avgtemp_c;
    private float totalsnow_cm;
    private Condition condition;

    public Day(float maxtemp_c, float mintemp_c, float avgtemp_c, float totalsnow_cm, Condition condition) {
        this.maxtemp_c = maxtemp_c;
        this.mintemp_c = mintemp_c;
        this.avgtemp_c = avgtemp_c;
        this.totalsnow_cm = totalsnow_cm;
        this.condition = condition;
    }

    public Day() {
    }

    public float getMaxtemp_c() {
        return maxtemp_c;
    }

    public void setMaxtemp_c(float maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public float getMintemp_c() {
        return mintemp_c;
    }

    public void setMintemp_c(float mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public float getAvgtemp_c() {
        return avgtemp_c;
    }

    public void setAvgtemp_c(float avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }

    public float getTotalsnow_cm() {
        return totalsnow_cm;
    }

    public void setTotalsnow_cm(float totalsnow_cm) {
        this.totalsnow_cm = totalsnow_cm;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
