package com.example.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository repo;
	
	public Iterable<Topic> getTopics(){
		 return repo.findAll();
	}
	
	public Topic getTopic(String id) {
		 Topic topic =  repo.findById(id).orElse( new Topic());
		 if ( topic.getId() == null ) {
			 /// runtime exception
			 throw new TopicNotFoundException();
		 }

		 return topic;
	}

	public String addTopic(Topic topic) {
		 repo.save(topic);
		 return "New topic added";	 
	}

	public String udpateTopic(Topic topic, String id) {
		repo.save(topic);
		return "Topic updated";
	}

	public String deleteTopic(String id) {
		repo.deleteById(id);
		return "deleted";
	}
	
	
}
