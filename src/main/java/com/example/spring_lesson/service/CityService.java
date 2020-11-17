package com.example.spring_lesson.service;

import com.example.spring_lesson.dto.CityDto;
import com.example.spring_lesson.model.City;

import java.util.Optional;

public interface CityService {
    Optional<City> findById(Long id);
    City findByName(String name);

    void save(CityDto productDto);

    void delete(Long id);
}
