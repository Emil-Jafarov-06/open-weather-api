package com.example.open_weather_api.model.apiResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Weather{
    public int id;
    public String main;
    public String description;
    public String icon;
}
