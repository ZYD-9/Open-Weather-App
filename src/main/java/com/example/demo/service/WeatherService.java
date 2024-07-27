package com.example.demo.service;
import com.example.demo.model.WeatherModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import java.util.Map;

public class WeatherService {
    @Value("${api.key}")
    private String apiKey;

    @Value("${api.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();


    public WeatherModel getWeather(String city) {
       String endpoint = baseUrl + "?q=" + city + "&appkey=" + apiKey;

        Map<String,Object> response = restTemplate.getForObject(endpoint, Map.class);

        WeatherModel weather = new WeatherModel();
        weather.setDescription(((Map<String, String>) ((List<Object>) response.get("weather")).get(0)).get("description"));
        weather.setTemperature(Double.parseDouble(((Map<String, Object>) response.get("main")).get("temp").toString()));
        return weather;
    }
}
