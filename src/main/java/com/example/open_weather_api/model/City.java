package com.example.open_weather_api.model;

import com.example.open_weather_api.model.dto.CityDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Weather> weathers = new ArrayList<>();

    public void addWeather(Weather weather){
        this.weathers.add(weather);
        weather.setCity(this);
    }

    public static CityDTO mapIntoDTO(City city){
        return CityDTO.builder()
                .id(city.getId())
                .name(city.getName())
                .country(city.getCountry())
                .weathers(city.getWeathers()).build();
    }

}
