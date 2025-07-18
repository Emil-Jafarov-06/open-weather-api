package com.example.open_weather_api.repository;

import com.example.open_weather_api.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    List<Weather> getWeatherByCity_Name(String cityName);

}

