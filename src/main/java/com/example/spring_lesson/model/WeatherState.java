package com.example.spring_lesson.model;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "weather_state")
//@TypeDef(
//        name = "list-array",
//        typeClass = ListArrayType.class
//)
public class WeatherState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_id")
    private Long cityId;

    @OneToMany
    @JoinTable(
            name="weather_state_conditions",
            joinColumns=@JoinColumn(name="weather_state_id", referencedColumnName="id")
    )
    private List<Integer> condition;

    @Column(name = "request_time")
    private java.util.Date requestTime;

    @Column(name = "temperature")
    private Double temperature;
}
