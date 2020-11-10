package com.example.spring_lesson.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainWeatherData {
    @JsonProperty("temp")
    private Double temp;
}
