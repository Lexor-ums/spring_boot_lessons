package com.example.spring_lesson;

import com.example.spring_lesson.configuration.WeatherConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(WeatherConfiguration.class)
public class SpringLessonApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringLessonApplication.class, args);
    }

}
