package com.example.spring_lesson.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "weather_state")
public class WeatherState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "city_id")
    private Long cityId;

    @ElementCollection
    private List<Integer> condition;

    @Column(name = "request_time")
    private Date requestTime;

    @Column(name = "temperature")
    private Double temperature;
}
