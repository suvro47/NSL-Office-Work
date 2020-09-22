package com.example.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository repo;
	
	public Iterable<Topic> getTopics(){
		 return repo.findAll();
	}
	
	public Topic getTopic(String id){
		 return repo.findById(id).orElse( new Topic());
	}

	public void addTopic(Topic topic) {
		repo.save(topic);
	}

	public void udpateTopic(Topic topic, String id) {
		repo.save(topic);
	}

	public String deleteTopic(String id) {
		repo.deleteById(id);
		return "deleted";
	}
	
	
}
