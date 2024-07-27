package com.example.demo.controller;
import com.example.demo.model.WeatherModel;
import com.example.demo.service.WeatherService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class WeatherController {
    private WeatherService weatherService;

    public String home() {
        return "index";
    }

    @GetMapping("/weather")
    public String getWeather(String city, Model model) {
       try{
        WeatherModel weather = weatherService.getWeather(city);
        model.addAttribute("weather");
        return weather.toString();
    }
       catch(Exception e){
           model.addAttribute("Cannot fetch weather data", e.getMessage());
           return "error";
       }
    }
}