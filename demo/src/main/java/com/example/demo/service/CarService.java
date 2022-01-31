package com.example.demo.service;



import com.example.demo.model.Car;

import java.util.Optional;

public interface CarService {
    Optional<Car> findById(Long id);

    Optional<Car> findByCarNumber(String carNumber);

    Optional<Car> findByCarBrandAndCarModel(String carModel, String carBrand);

    Car saveCar(Car car);

    void deleteCar(Long id);
}
