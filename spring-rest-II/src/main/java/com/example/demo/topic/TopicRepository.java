package com.example.demo.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository< Topic , String > {
	
	// getTopics()
	// getTopic(id)
	// addTopic(topic)
	// updateTopic(id,Topic)
	// deleteTopic(id)
}
