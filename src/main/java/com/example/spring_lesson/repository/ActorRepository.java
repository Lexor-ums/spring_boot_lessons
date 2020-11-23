package com.example.spring_lesson.repository;

import com.example.spring_lesson.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query("select b from Actor b where b.login = :login")
    Actor findByLogin(@Param("login") String login);
}
