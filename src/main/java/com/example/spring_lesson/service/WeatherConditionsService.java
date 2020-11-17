package com.example.spring_lesson.service;

import com.example.spring_lesson.dto.WeatherConditionsDto;
import com.example.spring_lesson.model.WeatherConditions;

import java.util.Optional;

public interface WeatherConditionsService {
    Optional<WeatherConditions> findById(Long id);

    void save(WeatherConditionsDto productDto);

    void delete(Long id);

    WeatherConditions getByCode(Integer code);
}
