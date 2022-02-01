package com.example.demo.service.impl;

import com.example.demo.model.Brand;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Optional<Car> findById(Long id) {
        return this.carRepository.findById(id);
    }

    @Override
    public Optional<Car> findByCarNumber(String carNumber) {
        return this.carRepository.findByCarNumber(carNumber);
    }

    @Override
    public Optional<Car> findByCarBrandAndCarModel(String carBrand, String carModel) {
        Brand brand = Brand.valueOf(carBrand);
        return this.carRepository.findByBrandAndModel(brand, carModel);
    }

    @Override
    public Optional<Car> findByEngineId(Long id) {
        return this.carRepository.findByEngineId(id);
    }

    @Override
    public List<Car> findByOwnerId(Long ownerId) {
        return this.carRepository.findByOwnerId(ownerId);
    }

    @Override
    public Car saveCar(Car car) {
        return this.carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        this.carRepository.deleteById(id);
    }
}
