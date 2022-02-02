package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BrandValidator implements ConstraintValidator<Brand, String> {
    List<String> brands = Stream.of(com.example.demo.model.Brand.values())
                                .map(com.example.demo.model.Brand::name)
                                .collect(Collectors.toList());
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return brands.contains(value);
    }
}
