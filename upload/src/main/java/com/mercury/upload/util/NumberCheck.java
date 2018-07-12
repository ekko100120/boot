package com.mercury.upload.util;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NumberCheckValidator.class)
public @interface NumberCheck {
}
