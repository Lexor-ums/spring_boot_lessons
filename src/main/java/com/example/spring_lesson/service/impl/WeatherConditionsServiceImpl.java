package com.example.spring_lesson.service.impl;

import com.example.spring_lesson.dto.WeatherConditionsDto;
import com.example.spring_lesson.mapper.WeatherConditionsMapper;
import com.example.spring_lesson.model.WeatherConditions;
import com.example.spring_lesson.repository.WeatherConditionsRepository;
import com.example.spring_lesson.service.WeatherConditionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherConditionsServiceImpl implements WeatherConditionsService {

    private final WeatherConditionsRepository weatherConditionsRepository;

    private final WeatherConditionsMapper weatherConditionsMapper;

    @Override
    public Optional<WeatherConditions> findById(Long id) {
        return weatherConditionsRepository.findById(id);
    }

    @Override
    public void save(WeatherConditionsDto weatherConditionsDto) {
        WeatherConditions weatherConditions = weatherConditionsMapper.toWeaWeatherConditions(weatherConditionsDto);
        weatherConditionsRepository.save(weatherConditions);
    }

    @Override
    public void delete(Long id) {
        weatherConditionsRepository.deleteById(id);
    }

    @Override
    public WeatherConditions getByCode(Integer code) {
        return weatherConditionsRepository.findByCode(code);
    }

}
