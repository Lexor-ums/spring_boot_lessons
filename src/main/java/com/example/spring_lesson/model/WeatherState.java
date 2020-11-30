package com.example.spring_lesson.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "weather_state")
public class WeatherState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", example = "1")
    private Long id;

    @Column(name = "city_id")
    @ApiModelProperty(name = "city_id", example = "1")
    private Long cityId;

    @OneToMany
    @JoinTable(
            name="weather_state_conditions",
            joinColumns=@JoinColumn(name="weather_state_id", referencedColumnName="id")
    )
    private List<Integer> condition;

    @Column(name = "request_time")
    @ApiModelProperty(name = "request_time", example = "31-08-2020 10:20:5")
    private java.util.Date requestTime;

    @Column(name = "temperature")
    @ApiModelProperty(name = "temperature", example = "-1.4")
    private Double temperature;
}
