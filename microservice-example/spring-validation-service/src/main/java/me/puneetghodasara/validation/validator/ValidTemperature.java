package me.puneetghodasara.validation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TemperatureValidator.class)
@Documented
public @interface ValidTemperature {

    /* This would be replaced in case of constraints are not met. */
    String message() default "Invalid Temperature";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // String value();
}
