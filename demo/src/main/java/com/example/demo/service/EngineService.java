package com.example.demo.service;

import com.example.demo.model.Engine;

import java.util.Optional;

public interface EngineService {
    Optional<Engine> findById(Long id);

    Optional<Engine> findByEngineNumber(String engineNumber);

    Engine saveEngine(Engine engine);

    void deleteEngine(Long id);

}
