package com.example.demo.repository;

import com.example.demo.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {

    Optional<Engine> findById(Long id);

    Optional<Engine> findByNumber(String engineNumber);
}
