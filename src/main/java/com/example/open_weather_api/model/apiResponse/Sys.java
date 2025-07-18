package com.example.open_weather_api.model.apiResponse;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sys{
    Integer type;
    Integer id;
    String country;
    Integer sunrise;
    Integer sunset;
}
