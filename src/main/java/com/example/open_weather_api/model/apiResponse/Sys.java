package com.example.open_weather_api.model.apiResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sys{
    public int type;
    public int id;
    public String country;
    public int sunrise;
    public int sunset;
}
