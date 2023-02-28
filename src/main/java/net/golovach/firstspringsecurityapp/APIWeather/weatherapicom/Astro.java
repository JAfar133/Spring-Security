package net.golovach.firstspringsecurityapp.APIWeather.weatherapicom;

public class Astro {
    private int is_moon_up;
    private int is_sun_up;

    public Astro(int is_moon_up, int is_sun_up) {
        this.is_moon_up = is_moon_up;
        this.is_sun_up = is_sun_up;
    }

    public Astro() {
    }

    public int getIs_moon_up() {
        return is_moon_up;
    }

    public void setIs_moon_up(int is_moon_up) {
        this.is_moon_up = is_moon_up;
    }

    public int getIs_sun_up() {
        return is_sun_up;
    }

    public void setIs_sun_up(int is_sun_up) {
        this.is_sun_up = is_sun_up;
    }
}
