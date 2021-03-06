package me.puneetghodasara.validation.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = { "me.puneetghodasara" })
@EnableWebMvc
@EnableJpaRepositories(basePackages = { "me.puneetghodasara.validation.persistence" })
@EntityScan(basePackages = { "me.puneetghodasara.validation.model" })
public abstract class ValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidatorApplication.class, args);
	}

	// @Bean
	// public MethodValidationPostProcessor bean() {
	// MethodValidationPostProcessor processor = new
	// MethodValidationPostProcessor();
	// // processor.setValidatedAnnotationType(Validated.class);
	// return processor;
	// }

}
