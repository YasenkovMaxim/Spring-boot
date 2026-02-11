package com.maxim.service.validation;

import com.maxim.annotations.IsAdult;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsAdultValidator implements ConstraintValidator<IsAdult, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value >= 18 && value <= 110;
    }
}
