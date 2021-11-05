package com.zooclinic.zooclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ZooclinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooclinicApplication.class, args);
	}

}
