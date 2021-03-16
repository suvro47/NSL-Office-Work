package com.junit.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	
	static Logger LOG = LoggerFactory.getLogger(Application.class);

	@Autowired
	private ProductRepository repo;

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		LOG.info("LOG ::::::::::::: Unit Test with Junit Jupiter :::::::::::::::::::::::: ");
	}

	@Override
	public void run(String... args) throws Exception {
				
		//Product product = repo.findByName("Polo tShirt");
		//LOG.info(product.getName());

		
		
	}

}
