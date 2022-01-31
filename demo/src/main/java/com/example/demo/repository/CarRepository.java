package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CarRepository extends JpaRepository<Car, Long > {

    Car findByCarNumber(String carNumber);

    Car findByBrandAndModel(Brand brand, String model);

    Car findByOwnerFirstName(String firstName);

    Car findByEngineNumber(String engineNumber);
}
