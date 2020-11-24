package com.example.spring_lesson.repository;

import com.example.spring_lesson.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    Actor findByLogin(String login);
}
