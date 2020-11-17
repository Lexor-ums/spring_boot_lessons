package com.example.spring_lesson.repository;

import com.example.spring_lesson.model.WeatherState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherStateRepository extends JpaRepository<WeatherState, Long> {
    @Query("select b from WeatherState b where b.cityId = :cityId")
    List<WeatherState> findByCityId(@Param("city_id") Long cityId);
}
