package com.example.spring_lesson.mapper;

import com.example.spring_lesson.dto.WeatherConditionsDto;
import com.example.spring_lesson.model.WeatherConditions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WeatherConditionsMapper {
    WeatherConditions toWeaWeatherConditions(WeatherConditionsDto weatherConditionsDto);
}
