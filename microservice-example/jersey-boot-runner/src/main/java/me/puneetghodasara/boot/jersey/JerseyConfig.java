package me.puneetghodasara.boot.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        packages(true, "me.puneetghodasara");
        // register(CustomException.class);
    }

}