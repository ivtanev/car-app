package com.example.demo.repository;


import com.example.demo.model.Brand;
import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long > {

    Optional<Car> findByCarNumber(String carNumber);

    Optional<Car> findByBrandAndModel(Brand brand, String model);

    List<Car> findByOwnerId(Long ownerId);

    Optional<Car> findByEngineId(Long engineId);
}
