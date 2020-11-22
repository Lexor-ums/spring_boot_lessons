package com.example.spring_lesson.service.impl;

import com.example.spring_lesson.dto.CityDto;
import com.example.spring_lesson.model.City;
import com.example.spring_lesson.repository.CityRepository;
import com.example.spring_lesson.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public City findByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public void save(CityDto cityDto) {
        if(cityRepository.findByName(cityDto.getName()) == null) {
            City city = new City();
            city.setName(cityDto.getName());
            cityRepository.save(city);
        }
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
