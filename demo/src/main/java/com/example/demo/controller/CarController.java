package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.OwnerDto;
import com.example.demo.model.Car;
import com.example.demo.model.Engine;
import com.example.demo.model.Owner;
import com.example.demo.service.CarService;
import com.example.demo.service.EngineService;
import com.example.demo.service.OwnerService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private EngineService engineService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    ResponseEntity<CarDto> findById(@PathVariable(value = "id") Long id) {
        Optional<Car> optionalCar = carService.findById(id);
        if (optionalCar.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping("/carNumber/{number}")
    ResponseEntity<CarDto> findByCarNumber(@PathVariable(value = "number") String carNumber) {
        Optional<Car> optionalCar = carService.findByCarNumber(carNumber);
        if (optionalCar.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping("/findCar/engine/{engineNumber}")
    ResponseEntity<CarDto> findByEngineNumber(@PathVariable(value = "engineNumber") String engineNumber) {
        Optional<Engine> optionalEngine = engineService.findByEngineNumber(engineNumber);
        if (optionalEngine.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Optional<Car> optionalCar = carService.findByEngineId(optionalEngine.get().getId());
        if (optionalCar.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping("/findCar/owner/{ownerId}")
    ResponseEntity<List<CarDto>> findByOwnerId(@PathVariable(value = "ownerId") Long ownerId) {
        Optional<Owner> optionalOwner = ownerService.findById(ownerId);
        if (optionalOwner.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<Car> cars = carService.findByOwnerId(optionalOwner.get().getId());
        if (cars.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<CarDto> mappedDto = new ArrayList<>();
        for (Car car : cars) {
            mappedDto.add(modelMapper.map(car, CarDto.class));
        }
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    ResponseEntity<CarDto> findByCarModelAndCarBrand(@RequestParam String brand, @RequestParam String model) {
        Optional<Car> optionalCar = carService.findByCarBrandAndCarModel(brand.toUpperCase(), model);
        if (optionalCar.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PostMapping
    ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto newCar) {
        Optional<Owner> optionalOwner;
        Car car = modelMapper.map(newCar, Car.class);
        car.setId(null);
        if(newCar.getOwnerId() != null) {
            optionalOwner = ownerService.findById(newCar.getOwnerId());
            car.setOwner(optionalOwner.get());
        }
        Car savedCar = carService.saveCar(car);
        CarDto mappedDto = modelMapper.map(savedCar, CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<CarDto> editCar(@Valid @RequestBody CarDto editCar, @PathVariable(value = "id") Long id) {
        Optional<Car> optionalCar = carService.findById(id);
        Optional<Engine> optionalEngine = engineService.findByEngineNumber(editCar.getEngine().getNumber());
        Car car = modelMapper.map(editCar, Car.class);
        if (optionalCar.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Optional<Owner> optionalOwner;
        if(editCar.getOwnerId() != null){
            optionalOwner = ownerService.findById(editCar.getOwnerId());
            if(optionalOwner.isPresent()){
                car.setOwner(optionalOwner.get());
            }
        }
        if(optionalEngine.isPresent()){
            car.setEngine(optionalEngine.get());
        }
        car.setId(id);
        Car editedCar = carService.saveCar(car);
        CarDto mappedDto = modelMapper.map(editedCar, CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<CarDto> deleteCar(@PathVariable(value = "id") Long id) {
        Optional<Car> optionalCar = carService.findById(id);
        if (optionalCar.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        carService.deleteCar(id);
        return ResponseEntity.ok(mappedDto);
    }
}
