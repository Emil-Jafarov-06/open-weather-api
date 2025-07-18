package com.example.open_weather_api.model.apiResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Main{
    Double temp;
    Double feels_like;
    Double temp_min;
    Double temp_max;
    Integer pressure;
    Integer humidity;
    Integer sea_level;
    Integer grnd_level;
}
