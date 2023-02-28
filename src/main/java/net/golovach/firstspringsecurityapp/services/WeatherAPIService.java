package net.golovach.firstspringsecurityapp.services;

import net.golovach.firstspringsecurityapp.APIWeather.WeatherAPIResponse;
import net.golovach.firstspringsecurityapp.util.DontExistCityException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherAPIService {
    private final String KEY = "9a68ce6399164942aef205153232002";
    private String city;
    public WeatherAPIResponse getWeather(String city) throws DontExistCityException {
        if(city.toLowerCase().equals("севастополь")) city = "Севастополь/Украина";
        if(city.toLowerCase().equals("санкт-петербург")||city.toLowerCase().equals("петербург")) city = "Sant-Petersburg";
        String url = "http://api.weatherapi.com/v1/forecast.json?key="+ KEY +"&q="+city+"&days=4&aqi=no&alerts=no&lang=ru";
        WeatherAPIResponse weatherResponse = getResponse(url);
        this.city=city;
        return weatherResponse;
    }

    private WeatherAPIResponse getResponse(String url) throws DontExistCityException {
        RestTemplate restTemplate = new RestTemplate();
        WeatherAPIResponse response=null;
        try {
            response = restTemplate.getForObject(url, WeatherAPIResponse.class);
        }catch (HttpClientErrorException e){
            HttpStatusCode str = e.getStatusCode();
            if(e.getMessage().equals("400 Bad Request: \"{\"error\":{\"code\":1006,\"message\":\"No matching location found.\"}}\"")){
                throw new DontExistCityException("Город с таким названием не существует");
            }
        }
        return response;
    }

    public String getCity() {
        return city;
    }
}
