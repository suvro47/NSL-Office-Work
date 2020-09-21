package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DepDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(DepDemoApplication.class, args);  // context : container of spring bean created in this line 
		System.out.println("Dependency Injection Demo........");
		
		Alien a = context.getBean(Alien.class);
		a.show();
		
		Alien a2 = context.getBean(Alien.class);
		a2.show();
		
	}

}
