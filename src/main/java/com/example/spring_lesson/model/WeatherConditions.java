package com.example.spring_lesson.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "conditions_codes")
public class WeatherConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", example = "1")
    private Long id;

    @Column(name = "code")
    @ApiModelProperty(name = "code", example = "400")
    private Integer code;

    @ApiModelProperty(name = "500", example = "Дождь")
    @Column(name = "value")
    private String value;

}
