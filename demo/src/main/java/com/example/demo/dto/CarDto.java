package com.example.demo.dto;

import com.example.demo.validator.Brand;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CarDto {

    private EngineDto engine;

    @Brand
    @NotEmpty(message = "Please provide a brand")
    private String brand;

    @NotEmpty(message = "Please provide a model")
    private String model;

    @Min(value = 1, message = "The value must be more than 0")
    @NotNull(message = "cubature can not be empty")
    private Integer yearOfManufacture;

    @NotEmpty(message = "Please provide a carNumber")
    private String carNumber;

    private Long ownerId;
}
