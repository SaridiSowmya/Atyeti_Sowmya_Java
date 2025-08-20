package com.example.weatheranalyzer.service;


import com.example.weatheranalyzer.model.WeatherData;
import com.example.weatheranalyzer.model.WeatherStats;
import com.example.weatheranalyzer.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public WeatherData saveWeatherData(WeatherData weatherData) {
        return weatherRepository.save(weatherData);
    }

    public List<WeatherData> getWeatherByCity(String city) {
        return weatherRepository.findByCity(city);
    }

    public List<WeatherData> getAllWeatherData() {
        return weatherRepository.findAll();
    }


    public WeatherStats calculateStats(String city) {
        List<WeatherData> dataList = weatherRepository.findByCity(city);

        if (dataList.isEmpty()) {
            return new WeatherStats(0, 0, 0);
        }

        double avgTemp = dataList.stream().mapToDouble(WeatherData::getTemperature).average().orElse(0);
        int maxHumidity = dataList.stream().mapToInt(WeatherData::getHumidity).max().orElse(0);
        int minHumidity = dataList.stream().mapToInt(WeatherData::getHumidity).min().orElse(0);

        return new WeatherStats(avgTemp, maxHumidity, minHumidity);
    }
}

