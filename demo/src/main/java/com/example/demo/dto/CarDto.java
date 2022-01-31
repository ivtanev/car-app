package com.example.demo.dto;

import com.example.demo.model.Brand;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CarDto {


    private EngineDto engine;

    @NotEmpty
    private String brand;

    @NotEmpty
    private String model;

    @Min(value = 1, message = "The value must be more than 0")
    @NotNull(message = "cubature can not be empty")
    private Integer yearOfManufacture;

    @NotEmpty
    private String carNumber;

    private OwnerDto owner;
}
