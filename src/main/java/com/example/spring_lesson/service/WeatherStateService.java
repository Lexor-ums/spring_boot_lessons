package com.example.spring_lesson.service;

import com.example.spring_lesson.dto.WeatherStateDto;
import com.example.spring_lesson.model.WeatherState;

import java.util.List;
import java.util.Optional;

public interface WeatherStateService {
    Optional<WeatherState> findById(Long id);

    void save(WeatherStateDto weatherStateDto);

    void delete(Long id);

    List<WeatherState> getByCityId(Long cityId);
}
