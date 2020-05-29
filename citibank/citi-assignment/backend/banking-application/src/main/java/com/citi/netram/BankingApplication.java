package com.citi.netram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*This is main Spring configuration class, it enables the auto-configuration feature of a Spring Boot application.*/

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}
 
}
