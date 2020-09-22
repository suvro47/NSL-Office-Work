package io.spring_boot_maven_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class maven_project_application {

	public static void main(String[] args) {
		SpringApplication.run(maven_project_application.class, args);  // run : static method bcz called by class name 
	}

}
