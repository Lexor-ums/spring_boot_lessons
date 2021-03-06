package com.example.spring_lesson.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

    @JsonProperty("description")
    String description;

    @Column(name = "id")
    private Integer id;

    @Column(name = "main")
    private String main;

}
