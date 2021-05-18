package com.spring.boot.nosql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMongodbApplication implements CommandLineRunner {

	
	@Autowired
	TutoRepository tutoRepository;
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		tutoRepository.save( new Tutorial("UX-03", "How to do well in programming") );
		tutoRepository.save( new Tutorial("UX-04", "How to do well in public speaking") );
		
		Tutorial tutorial = tutoRepository.findById("UX-03")
				.orElse( new Tutorial());
		
		LOG.info("Tutorial : " + tutorial.toString());
		LOG.info("Running.................");
		
	}
	
	
	

}
