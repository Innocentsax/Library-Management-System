package dev.Innocent.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ZenByZenithValidator implements ConstraintValidator<ZenByZenith, String> {

    private String emailSuffix;
    @Override
    public void initialize(ZenByZenith zenByZenith) {
        emailSuffix = zenByZenith.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (s != null){
            result = s.endsWith(emailSuffix);
        }
        else {
            result = true;
        }
        return result;
    }
}
