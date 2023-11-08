package com.chandilove.appchl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChandiloveBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChandiloveBackendApplication.class, args);
	}

}
