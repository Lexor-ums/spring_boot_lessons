package com.example.spring_lesson.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Primary
@ConfigurationProperties(prefix = "weather")
@ConstructorBinding
@Data
public class WeatherConfiguration {

    private  String url;
    private  String apiKey;
    private  String lang;
    private  String units;
}
