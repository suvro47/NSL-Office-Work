package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaProstgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaProstgresApplication.class, args);
		System.out.println("Spring boot | Spring Data JPA | Postgresql");
	}

}
