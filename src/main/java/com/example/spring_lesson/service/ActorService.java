package com.example.spring_lesson.service;

import com.example.spring_lesson.model.Actor;

public interface ActorService {
    Actor findByLogin(String name);
}
