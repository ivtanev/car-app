package com.example.demo.service;

import com.example.demo.model.Engine;

import java.util.Optional;

public interface EngineService {
    Optional<Engine> findById(Long id);

    Engine saveEngine(Engine engine);

    void deleteEngine(Long id);

}
