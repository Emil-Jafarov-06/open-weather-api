package com.example.open_weather_api.controller;

import com.example.open_weather_api.model.City;
import com.example.open_weather_api.model.Weather;
import com.example.open_weather_api.model.dto.CityDTO;
import com.example.open_weather_api.model.request.CityRequest;
import com.example.open_weather_api.service.WeatherService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class WeatherController {

    private final WeatherService weatherService;

    @PostMapping("/city")
    public ResponseEntity<CityDTO> addCity(@RequestBody CityRequest cityRequest) {
        return ResponseEntity.ok(weatherService.addCity(cityRequest));
    }

    @GetMapping("/city/{cityName}")
    public ResponseEntity<?> getLatestWeatherInfo(@PathVariable @NotBlank String cityName){
        return ResponseEntity.ok(weatherService.getLatestInfo(cityName));
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transferIntoExcel(){
        try {
            weatherService.transferInfoIntoExcelFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/city/getData")
    public void getDataFromCite(){
        weatherService.getWeatherInfoForCity();
    }
}
