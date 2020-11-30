package com.example.spring_lesson;

import com.example.spring_lesson.configuration.WeatherConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties(WeatherConfiguration.class)
public class SpringLessonApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringLessonApplication.class, args);
    }

}
