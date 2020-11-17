package com.example.spring_lesson.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class WeatherStateDto {
    private Long cityId;
    private List<Integer> condition;
    private Date requestTime;
    private Double temperature;
}
