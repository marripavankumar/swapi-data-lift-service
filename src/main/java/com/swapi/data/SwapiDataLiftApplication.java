package com.swapi.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication()
@OpenAPIDefinition(info = @Info(title = "Star wars API", version = "1.0", description = "Documentation APIs v1.0"))
public class SwapiDataLiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwapiDataLiftApplication.class, args);
		
	}
	


}
