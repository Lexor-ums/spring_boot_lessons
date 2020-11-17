package com.example.spring_lesson.repository;

import com.example.spring_lesson.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select b from City b where b.name = :name")
    City findByName(@Param("name") String name);}
