package com.example.spring_lesson.service.impl;

import com.example.spring_lesson.dto.WeatherStateDto;
import com.example.spring_lesson.model.WeatherState;
import com.example.spring_lesson.repository.WeatherStateRepository;
import com.example.spring_lesson.service.WeatherStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class WeatherStateServiceImpl  implements WeatherStateService {

    private final WeatherStateRepository weatherStateRepository;

    @Override
    public Optional<WeatherState> findById(Long id) {
        return weatherStateRepository.findById(id);
    }

    @Override
    public void save(WeatherStateDto weatherStateDto) {
        WeatherState weatherState = new WeatherState();
        weatherState.setCityId(weatherStateDto.getCityId());
        weatherState.setCondition(weatherStateDto.getCondition());
        weatherState.setRequestTime(weatherStateDto.getRequestTime());
        weatherState.setTemperature(weatherStateDto.getTemperature());
        weatherState.setRequestTime(new java.util.Date());
        weatherStateRepository.save(weatherState);
    }

    @Override
    public void delete(Long id) {
        weatherStateRepository.deleteById(id);
    }

    @Override
    public List<WeatherState> getByCityId(Long cityId) {
        return weatherStateRepository.findByCityId(cityId);
    }
}
