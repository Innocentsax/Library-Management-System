package dev.Innocent.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ZenByZenithValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZenByZenith {

    public String value() default "ZenByZenith";
    public String message() default "Must end with ZenByZenith";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
