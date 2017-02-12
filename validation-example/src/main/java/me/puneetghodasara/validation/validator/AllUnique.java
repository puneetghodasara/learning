package me.puneetghodasara.validation.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AllUniqueValidator.class)
@Documented
public @interface AllUnique {

	String message() default "Problem";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String value();

//	@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
//	@Retention(RetentionPolicy.RUNTIME)
//	@Documented
//	@interface List {
//		AllUnique[] value();
//	}
}
