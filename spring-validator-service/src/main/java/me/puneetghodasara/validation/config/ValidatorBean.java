package me.puneetghodasara.validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class ValidatorBean {

	@Bean
	public MethodValidationPostProcessor bean() {
		MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
		// processor.setValidatedAnnotationType(Validated.class);
		return processor;
	}
}
