package com.example.spring_lesson.mapper;

import com.example.spring_lesson.dto.CityDto;
import com.example.spring_lesson.model.City;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface CityMapper {
    City toCity(CityDto cityDto);
}
