package com.example.learn.customValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DiscountCodeValidator.class})
public @interface DiscountCode {
    String message() default "{must start with OFF}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

    String value() default  "OFF";


}
