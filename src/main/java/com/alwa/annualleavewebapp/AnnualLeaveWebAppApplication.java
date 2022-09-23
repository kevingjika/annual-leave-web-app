package com.alwa.annualleavewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
public class AnnualLeaveWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnualLeaveWebAppApplication.class, args);
	}

}
