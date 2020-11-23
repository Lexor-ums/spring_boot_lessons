package com.example.spring_lesson.service.impl;

import com.example.spring_lesson.model.Actor;
import com.example.spring_lesson.repository.ActorRepository;
import com.example.spring_lesson.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    ActorRepository actorRepository;

    @Override
    public Actor findByLogin(String name) {
        return actorRepository.findByLogin(name);
    }
}
