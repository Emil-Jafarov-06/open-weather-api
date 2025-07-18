package com.example.open_weather_api.repository;

import com.example.open_weather_api.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
