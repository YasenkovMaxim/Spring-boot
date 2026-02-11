package com.maxim.annotations;

import com.maxim.service.validation.IsAdultValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IsAdultValidator.class})

public @interface IsAdult {
    String message() default "Should more than 18 age and less than 110 age";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
