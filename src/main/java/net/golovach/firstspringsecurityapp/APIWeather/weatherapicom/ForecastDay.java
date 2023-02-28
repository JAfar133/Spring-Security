package net.golovach.firstspringsecurityapp.APIWeather.weatherapicom;


import net.golovach.firstspringsecurityapp.APIWeather.DateFormat;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ForecastDay {
    private String date;
    private Day day;
    private List<Hour> hour;
    private Astro astro;



    public ForecastDay() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String strDate) {
        this.date = DateFormat.format(strDate);
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public List<Hour> getHour() {
        return hour;
    }

    public void setHour(List<Hour> hour) {
        this.hour = hour;
    }
}
