package com.example.demo.model;

public class WeatherModel {

    private String city;
    private String description;
    private double temperature;

    public String getCity() {
        return city;
    }

    private void setCity(String city){
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public void setTemperature(double temperature) {
        this.temperature = temperature;

    }

    public double getTemperature() {
        return temperature;
    }


}
