package com.example.open_weather_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

}
