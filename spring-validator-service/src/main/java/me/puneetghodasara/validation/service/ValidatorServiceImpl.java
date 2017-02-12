package me.puneetghodasara.validation.service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.stereotype.Component;

@Component("validatorService")
public class ValidatorServiceImpl implements ValidatorService {

	@Override
	public List<String> validate(Object object) {

		Validator validator = Validation.buildDefaultValidatorFactory()
				.getValidator();
		Set<ConstraintViolation<Object>> constraint = validator.validate(object);

		return constraint.stream()
				.map(cv -> cv.getMessage())
				.collect(Collectors.toList());

	}

}
