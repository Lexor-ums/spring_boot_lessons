package com.example.spring_lesson.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "conditions_codes")
public class WeatherConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code")
    private Integer code;

    @Column(name = "value")
    private String value;

}
