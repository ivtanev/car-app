package com.example.demo.service.impl;

import com.example.demo.model.Engine;
import com.example.demo.repository.EngineRepository;
import com.example.demo.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Optional<Engine> findById(Long id) {
        return this.engineRepository.findById(id);
    }

    @Override
    public Engine saveEngine(Engine engine) {
        return this.engineRepository.save(engine);
    }

    @Override
    public void deleteEngine(Long id) {
        this.engineRepository.deleteById(id);
    }
}
