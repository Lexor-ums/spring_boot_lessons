package com.example.spring_lesson.controller;

import com.example.spring_lesson.entity.WeatherJson;
import com.example.spring_lesson.entity.weather.WeatherInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class WeatherController {

    private final RestTemplate restTemplate;

    @Value("${weather.api.url}")
    private  String baseUri;

    @Value("${weather.api.apiKey}")
    private  String apiKey;

    @Value("${weather.api.lang}")
    private  String lang;

    @Value("${weather.api.units}")
    private  String units;

    public WeatherController(RestTemplateBuilder builder)
    {
        restTemplate = builder.build();
    }

    @GetMapping("/today_weather/")
    public ResponseEntity<String> showWeather(){
        return new ResponseEntity<>("Добавьце в адресную строку название города. Можно кирилицей", HttpStatus.OK);
    }
    @GetMapping("/today_weather/{city}")
    public ResponseEntity<String> showWeather(@PathVariable(name = "city") String city) throws JsonProcessingException {
        String weatherState = "";
        URI targetUrl = UriComponentsBuilder.fromUriString(baseUri)
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("lang", lang)
                .queryParam("units", units)
                .build()
                .encode()
                .toUri();

        WeatherJson response = restTemplate.getForObject(targetUrl, WeatherJson.class);

        for ( WeatherInfo state : response.getWeatherInfos())
            weatherState = weatherState.join(",",  state.getDescription());
        String todayWeather = "Сегодня в городе %s %s .Температура %s градуса(ов) по Цельсию";
        return new ResponseEntity<>(String.format(todayWeather, response.getName(), weatherState, response.getMainWeatherData().getTemp()),
                HttpStatus.OK);
    }
}
