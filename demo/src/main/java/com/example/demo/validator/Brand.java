package com.example.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = com.example.demo.validator.BrandValidator.class)
@Documented
public @interface Brand {
    String message() default "Brand is not allowed. Brand has to be MOSKVICH, LADA, MERCEDES, BMW";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
