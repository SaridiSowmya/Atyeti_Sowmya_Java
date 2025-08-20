package com.example.weatheranalyzer.controller;

import com.example.weatheranalyzer.model.*;
import com.example.weatheranalyzer.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<WeatherData>> addWeather(@RequestBody WeatherData weatherData) {
        WeatherData saved = weatherService.saveWeatherData(weatherData);
        return ResponseEntity.ok(new ApiResponse<>("Weather data saved", saved));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<WeatherData>>> getAllWeather() {
        List<WeatherData> allData = weatherService.getAllWeatherData();
        return ResponseEntity.ok(new ApiResponse<>("All weather data fetched", allData));
    }

    @GetMapping("/{city}")
    public ResponseEntity<ApiResponse<List<WeatherData>>> getWeatherByCity(@PathVariable String city) {
        List<WeatherData> data = weatherService.getWeatherByCity(city);
        return ResponseEntity.ok(new ApiResponse<>("Weather data fetched", data));
    }

    @GetMapping("/{city}/stats")
    public ResponseEntity<ApiResponse<WeatherStats>> getWeatherStats(@PathVariable String city) {
        WeatherStats stats = weatherService.calculateStats(city);
        return ResponseEntity.ok(new ApiResponse<>("Weather stats calculated", stats));
    }
}

