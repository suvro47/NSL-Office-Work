package spring.nosql.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SampleProjectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleProjectApplication.class, args);
	}

}
