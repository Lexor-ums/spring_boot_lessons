package com.example.spring_lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringLessonApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringLessonApplication.class, args);
    }

}
