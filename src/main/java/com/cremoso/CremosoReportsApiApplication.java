package com.cremoso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication(scanBasePackages = "com.cremoso")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CremosoReportsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CremosoReportsApiApplication.class, args);
	}


}
