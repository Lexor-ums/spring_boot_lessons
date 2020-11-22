package com.example.spring_lesson.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherStateDto {
    public void addCondition(Integer code){
        condition.add(code);
    }
    private Long cityId;
    private List<Integer> condition = new ArrayList<>();
    private java.sql.Date requestTime;
    private Double temperature;
}
