package com.example.spring_lesson.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Primary
@ConfigurationProperties(prefix = "weather")
@ConstructorBinding
@Getter
@Setter
public class WeatherConfiguration {

    private  String url;
    private  String apiKey;
    private  String lang;
    private  String units;
}
