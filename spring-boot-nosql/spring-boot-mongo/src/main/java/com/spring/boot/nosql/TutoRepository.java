package com.spring.boot.nosql;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutoRepository extends MongoRepository<Tutorial, String> {

	List<Tutorial> findByTitle(String title);

}
