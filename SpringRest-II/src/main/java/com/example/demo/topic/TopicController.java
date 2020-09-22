package com.example.demo.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController   // response return as json 
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("/topics")
	public Iterable<Topic> getTopics() {
		return topicService.getTopics();
	}
	
	@GetMapping("/topic/{id}")
	public Topic getTopic( @PathVariable String id) { 
		return topicService.getTopic(id);
	}
	
	@PostMapping("/topic")
	public void addTopic( @RequestBody Topic topic ) { // requestbody is used to accept the json data
		topicService.addTopic(topic);
	}
	
	@PutMapping("/topic/{id}")
	public void updateTopic( @RequestBody Topic topic,  @PathVariable String id ) {
		topicService.udpateTopic(topic,id);
	}
	
	@DeleteMapping("/topic/{id}")
	public String deleteTopic( @PathVariable String id) { 
		return topicService.deleteTopic(id);
	}
	

}
