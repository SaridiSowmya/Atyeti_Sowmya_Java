package com.example.weatheranalyzer.model;

public class WeatherStats {
    private double avgTemperature;
    private int maxHumidity;
    private int minHumidity;

    public WeatherStats(double avgTemperature, int maxHumidity, int minHumidity) {
        this.avgTemperature = avgTemperature;
        this.maxHumidity = maxHumidity;
        this.minHumidity = minHumidity;
    }


    public double getAvgTemperature() {
        return avgTemperature;
    }
    public void setAvgTemperature(double avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public int getMaxHumidity() {
        return maxHumidity;
    }
    public void setMaxHumidity(int maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    public int getMinHumidity() {
        return minHumidity;
    }
    public void setMinHumidity(int minHumidity) {
        this.minHumidity = minHumidity;
    }
}

