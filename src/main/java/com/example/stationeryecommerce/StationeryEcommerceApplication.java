package com.example.stationeryecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class StationeryEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationeryEcommerceApplication.class, args);
	}

}
