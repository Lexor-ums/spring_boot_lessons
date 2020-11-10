package com.example.spring_lesson.entity;

import com.example.spring_lesson.entity.weather.MainWeatherData;
import com.example.spring_lesson.entity.weather.WeatherInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherJson {
    public int ff = 1;
    @JsonProperty("main")
    private MainWeatherData mainWeatherData;

    @JsonProperty("weather")
    private List<WeatherInfo> weatherInfos;

    @JsonProperty("name")
    private String name;
}
