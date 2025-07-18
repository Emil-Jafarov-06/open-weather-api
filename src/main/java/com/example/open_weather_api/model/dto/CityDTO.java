package com.example.open_weather_api.model.dto;

import com.example.open_weather_api.model.Weather;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityDTO {

    Long id;
    String name;
    String country;
    @JsonIgnore
    List<Weather> weathers = new ArrayList<>();

}
