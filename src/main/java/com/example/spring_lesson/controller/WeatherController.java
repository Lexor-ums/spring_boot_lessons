package com.example.spring_lesson.controller;

import com.example.spring_lesson.service.WeatherReceiveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherReceiveService weatherReceiveService;

    @GetMapping("/today_weather/")
    public ResponseEntity<String> showWeather(){
        return new ResponseEntity<>("Добавьце в адресную строку название города. Можно кирилицей", HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('request_perm')")
    @GetMapping("/today_weather/{city}")
    public ResponseEntity<String> showWeather(@PathVariable(name = "city") String city)  {
        return new ResponseEntity<>(weatherReceiveService.getWeather(city), HttpStatus.OK);
    }
}
