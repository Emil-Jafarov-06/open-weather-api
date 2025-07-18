package com.example.open_weather_api.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeatherDTO {

    Long id;
    Double temperature;
    Integer humidity;
    String description;
    LocalDateTime timestamp;
    String cityName;

}
