package com.spring.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingInSpringApplication implements CommandLineRunner {


	Logger LOG = LoggerFactory.getLogger(LoggingInSpringApplication.class);

	@Autowired
	BookRepository bookrepo;

	public static void main(String[] args) {
		SpringApplication.run(LoggingInSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book = new Book("Head First Java");
		Book book2 = new Book("Teach Yourself C");

		bookrepo.save(book);
		bookrepo.save(book2);

		LOG.debug("This is a debug message");
        LOG.info("This is info message");
		
		LOG.warn("This is a warn message");
		LOG.error("This is an error message");

	}

}
