package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootEmailTemplateApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailTemplateApplication.class, args);
		System.out.println("Email Sending with template Running..............");
	}
}


