package com.example.weatheranalyzer.repository;

import com.example.weatheranalyzer.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherData, Integer> {
    List<WeatherData> findByCity(String city);
}
