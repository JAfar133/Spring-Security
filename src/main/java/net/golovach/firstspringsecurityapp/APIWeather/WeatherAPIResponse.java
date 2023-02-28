package net.golovach.firstspringsecurityapp.APIWeather;

import net.golovach.firstspringsecurityapp.APIWeather.weatherapicom.Current;
import net.golovach.firstspringsecurityapp.APIWeather.weatherapicom.Forecast;
import net.golovach.firstspringsecurityapp.APIWeather.weatherapicom.Location;

public class WeatherAPIResponse {
    private Location location;
    private Current current;
    private Forecast forecast;

    public WeatherAPIResponse(Location location, Current current, Forecast forecast) {
        this.location = location;
        this.current = current;
        this.forecast = forecast;
    }

    public WeatherAPIResponse() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
