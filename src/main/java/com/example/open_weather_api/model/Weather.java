package com.example.open_weather_api.model;

import com.example.open_weather_api.model.dto.WeatherDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Weather {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double temperature;
    Integer humidity;
    String description;
    LocalDateTime timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @JsonManagedReference
    City city;

    public static WeatherDTO mapIntoDTO(Weather weather){
        return WeatherDTO.builder()
                .id(weather.getId())
                .temperature(weather.getTemperature())
                .humidity(weather.getHumidity())
                .description(weather.getDescription())
                .timestamp(weather.getTimestamp())
                .cityName(weather.getCity().getName()).build();
    }

}
