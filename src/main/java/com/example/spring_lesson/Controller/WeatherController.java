package com.example.spring_lesson.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    final RestTemplate restTemplate;
    final String apiKey = "73eef1b8900294857cf8521aea0abe3f";

    public WeatherController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/today_weather/")
    public ResponseEntity<String> showWeather(){
        return new ResponseEntity<>("Добавьце в адресную строку название города. Можно кирилицей", HttpStatus.OK);
    }
    @GetMapping("/today_weather/{city}")
    public ResponseEntity<String> showWeather(@PathVariable(name = "city") String city) throws JsonProcessingException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&lang=ru&units=metric";
        String response= restTemplate.getForObject(String.format(url, city, apiKey),  String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        String weatherState = "";
        String temperature = "";
        String location = "";
        for ( JsonNode state : root.findValues("description"))
            weatherState = weatherState.join(",",  state.asText());
        temperature = root.findValue("temp").asText();
        location = root.findValue("name").asText();
        String todayWeather = "Сегодня в городе %s %s .Температура %s градуса(ов) по Цельсию";
        return new ResponseEntity<>(String.format(todayWeather, location, weatherState, temperature), HttpStatus.OK);
    }
}
