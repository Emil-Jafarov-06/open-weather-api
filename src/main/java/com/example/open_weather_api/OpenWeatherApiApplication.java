package com.example.open_weather_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import javax.swing.text.DateFormatter;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class OpenWeatherApiApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(OpenWeatherApiApplication.class, args);
    }

}
