package me.puneetghodasara.boot.jersey;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		// property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		packages(true, "me.puneetghodasara");
		// register(CustomException.class);
	}

}