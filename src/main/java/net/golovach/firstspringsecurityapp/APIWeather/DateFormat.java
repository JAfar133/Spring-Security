package net.golovach.firstspringsecurityapp.APIWeather;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {

    public static String format(String date){
        DateTimeFormatter input1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter input2 = DateTimeFormat.forPattern("yyyy-MM-dd");
        SimpleDateFormat output1 = new SimpleDateFormat("d MMMM HH:mm - E.", new Locale("ru"));
        SimpleDateFormat output2 = new SimpleDateFormat("d MMMM - E.", new Locale("ru"));
        try {
            Date time = DateTime.parse(date, input1).toDate();
            return output1.format(time);
        }catch (Exception e){
            Date time = DateTime.parse(date, input2).toDate();
            return output2.format(time);
        }
    }
}
