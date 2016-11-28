package me.puneetghodasara.validation.boot;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import me.puneetghodasara.validation.exception.CustomException;
import me.puneetghodasara.validation.exception.CustomValidationException;
import me.puneetghodasara.validation.service.RegistrationEndpoint;

@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		// property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		// register(GreetingController.class);
		register(CustomException.class);
		register(CustomValidationException.class);
		register(RegistrationEndpoint.class);
	}

}