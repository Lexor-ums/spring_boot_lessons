package com.example.spring_lesson.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
}
