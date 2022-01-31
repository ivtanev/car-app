package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EngineDto {

    @Size(min = 5, message = "number must be at least 5 symbols")
    @NotEmpty(message = "Please provide a number")
    private String number;

    @Min(value = 1, message = "The value must be more than 0")
    @NotNull(message = "cubature can not be empty")
    private Integer cubature;

    @Min(value = 1, message = "The value must be more than 0")
    @NotNull(message = "horsPower can not be empty")
    private Integer hoursPower;

}
