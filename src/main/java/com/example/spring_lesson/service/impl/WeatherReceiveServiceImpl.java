package com.example.spring_lesson.service.impl;

import com.example.spring_lesson.configuration.WeatherConfiguration;
import com.example.spring_lesson.entity.WeatherJson;
import com.example.spring_lesson.entity.weather.WeatherInfo;
import com.example.spring_lesson.service.WeatherReceiveService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class WeatherReceiveServiceImpl implements WeatherReceiveService {

    private final WeatherConfiguration configuration;
    private final RestTemplate restTemplate;

    public WeatherReceiveServiceImpl(WeatherConfiguration configuration, RestTemplateBuilder restTemplateBuilder) {
        this.configuration = configuration;
        this.restTemplate = restTemplateBuilder.build();
    }

    private String formatJson(WeatherJson weatherJson){
        if (weatherJson == null)
            return "";
        String weatherState = "";
        for ( WeatherInfo state : weatherJson.getWeatherInfos())
            weatherState = String.join(",",  state.getDescription());
        String todayWeather = "Сегодня в городе %s %s .Температура %s градуса(ов) по Цельсию";
        return String.format(todayWeather, weatherJson.getName(), weatherState,
                weatherJson.getMainWeatherData().getTemp());
    }

    @Override
    public String getWeather(String city) {
        URI targetUrl = UriComponentsBuilder.fromUriString(configuration.getUrl())
                .queryParam("q", city)
                .queryParam("appid", configuration.getApiKey())
                .queryParam("lang", configuration.getLang())
                .queryParam("units", configuration.getUnits())
                .build()
                .encode()
                .toUri();
        return formatJson(restTemplate.getForObject(targetUrl, WeatherJson.class));
    }
}
