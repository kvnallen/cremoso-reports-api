package com.cremoso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
public class CremosoReportsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CremosoReportsApiApplication.class, args);
	}
	

}
