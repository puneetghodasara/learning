package me.puneetghodasara.validation.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = { "me.puneetghodasara.java" })
@EnableWebMvc
@EnableJpaRepositories(basePackages = { "me.puneetghodasara.java.persistence" })
@EntityScan(basePackages = { "me.puneetghodasara.java.model" })
public abstract class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public MethodValidationPostProcessor bean() {
		MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
		// processor.setValidatedAnnotationType(Validated.class);
		return processor;
	}

}
