package com.example.learn.customValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DiscountCodeValidator implements ConstraintValidator<DiscountCode, String> {
    String discountPrefix;


    @Override
    public void initialize(DiscountCode constraintAnnotation) {
        discountPrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Boolean result;
        if (value != null) {
            result = value.startsWith(discountPrefix);
        } else
            result = false;
        return result;
    }
}
