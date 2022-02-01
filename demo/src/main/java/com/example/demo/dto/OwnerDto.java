package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
public class OwnerDto {

    @NotNull(message = "first name can not be empty")
    private String firstName;

    @NotNull(message = "last name can not be empty")
    private String lastName;

    @PastOrPresent
    private LocalDate dateOfBirth;
}
