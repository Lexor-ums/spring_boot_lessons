package com.example.spring_lesson.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", example = "1")
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(name = "name", example = "ADMIN")
    private String name;
}

