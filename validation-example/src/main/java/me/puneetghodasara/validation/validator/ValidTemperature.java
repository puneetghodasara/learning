package me.puneetghodasara.validation.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
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
