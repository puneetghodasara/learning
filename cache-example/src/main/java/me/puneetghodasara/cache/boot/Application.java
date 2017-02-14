package me.puneetghodasara.cache.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = { "me.puneetghodasara" })
@EnableWebMvc
@EnableJpaRepositories(basePackages = { "me.puneetghodasara" })
@EntityScan(basePackages = { "me.puneetghodasara" })
@EnableCaching
public abstract class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		System.out.println("----Start----");

	}

}
