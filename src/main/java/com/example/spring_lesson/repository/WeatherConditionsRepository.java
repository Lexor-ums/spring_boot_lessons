package com.example.spring_lesson.repository;

import com.example.spring_lesson.model.WeatherConditions;
import com.example.spring_lesson.model.WeatherState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherConditionsRepository extends JpaRepository<WeatherConditions, Long> {
    @Query("select b from WeatherConditions b where b.code = :code")
    WeatherConditions findByCode(@Param("code") int code);
}
