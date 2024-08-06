package com.example.otrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*

@author ishani.s
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.otrs.Repository")
public class OtrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtrsApplication.class, args);
	}

}
