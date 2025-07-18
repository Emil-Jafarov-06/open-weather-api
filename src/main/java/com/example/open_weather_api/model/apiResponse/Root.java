package com.example.open_weather_api.model.apiResponse;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Root{
    Coord coord;
    ArrayList<Weather> weather;
    String base;
    Main main;
    Integer visibility;
    Wind wind;
    Rain rain;
    Clouds clouds;
    Integer dt;
    Sys sys;
    Integer timezone;
    Integer id;
    String name;
    Integer cod;
}
