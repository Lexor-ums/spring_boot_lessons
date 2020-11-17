package com.example.spring_lesson.controller;

import com.example.spring_lesson.service.WeatherReceiveService;
import com.example.spring_lesson.service.impl.WeatherLogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherLogController {
    private final WeatherLogServiceImpl weatherLogServiceImpl;

    @GetMapping("/weather_log/")
    public ResponseEntity<String> showWeather(){
        return new ResponseEntity<>("Добавьце в адресную строку название города. Можно кирилицей", HttpStatus.OK);
    }
    @GetMapping("/weather_log/{city}")
    public ResponseEntity<String> showWeather(@PathVariable(name = "city") String city)  {
        return new ResponseEntity<>(weatherLogServiceImpl.getLog(city), HttpStatus.OK);
    }
}
