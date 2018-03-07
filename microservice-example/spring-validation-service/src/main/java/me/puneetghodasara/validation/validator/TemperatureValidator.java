package me.puneetghodasara.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TemperatureValidator implements ConstraintValidator<ValidTemperature, Temperature> {

    private static final String profile = "WINTER";

    @Override
    public void initialize(ValidTemperature constraintAnnotation) {
    }

    @Override
    public boolean isValid(Temperature value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (value == null) {
            context.buildConstraintViolationWithTemplate("Temperature can not be null.")
                    .addConstraintViolation();
            return false;
        }

        if (profile.equalsIgnoreCase("WINTER")) {

            if (value.compareTo(new Temperature(10D)) < 0) {
                context.buildConstraintViolationWithTemplate("Temperature can not be set lower than 10 in winter.")
                        .addConstraintViolation();
                return false;
            }
            if (value.compareTo(new Temperature(30D)) > 0) {
                context.buildConstraintViolationWithTemplate("Temperature can not be set higher than 30 in winter.")
                        .addConstraintViolation();
                return false;
            }

        } else if (profile.equalsIgnoreCase("SUMMER")) {
            context.buildConstraintViolationWithTemplate("Summer profile is not loaded.")
                    .addConstraintViolation();
            return false;
        } else {
            context.buildConstraintViolationWithTemplate("Invalid profile for temperature validation.")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

}
