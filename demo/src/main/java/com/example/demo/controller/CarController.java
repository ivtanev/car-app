package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    ResponseEntity<CarDto> findById(@PathVariable(value = "id")Long id){
        Optional<Car> optionalCar = carService.findById(id);
        if(optionalCar.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping("/carNumber")
    ResponseEntity<CarDto> findByCarNumber(@RequestParam("number") String carNumber){
        Optional<Car> optionalCar = carService.findByCarNumber(carNumber);
        if(optionalCar.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    ResponseEntity<CarDto> findByCarModelAndCarBrand(@RequestParam("carParam") List<String> carParams){
        Optional<Car> optionalCar = carService.findByCarBrandAndCarModel(carParams.get(0), carParams.get(1));
        if(optionalCar.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PostMapping
    ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto newCar){
        Car car = modelMapper.map(newCar, Car.class);
        Car savedCar = carService.saveCar(car);
        CarDto mappedDto = modelMapper.map(savedCar, CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<CarDto> editCar(@Valid @RequestBody CarDto editCar, @PathVariable(value = "id")Long id){
        Optional<Car> optionalCar = carService.findById(id);
        if(optionalCar.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Car car = modelMapper.map(editCar, Car.class);
        car.setId(id);
        Car editedCar = carService.saveCar(car);
        CarDto mappedDto = modelMapper.map(editedCar, CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<CarDto> deleteCar(@PathVariable(value = "id")Long id){
        Optional<Car> optionalCar = carService.findById(id);
        if(optionalCar.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        carService.deleteCar(id);
        return ResponseEntity.ok(mappedDto);
    }
}
