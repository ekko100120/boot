package com.mercury.upload.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class NumberCheckValidator implements ConstraintValidator<NumberCheck,Integer> {

    @Override
    public void initialize(NumberCheck constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
