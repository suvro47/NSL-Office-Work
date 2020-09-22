package io.spring_boot_maven_project.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	/// hand made data | here you have to fetch data from database 
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring Boot", "Spring Boot Descriptiong"),
			new Topic("Java","Java Core", "Java core descriprion")
		));
	
	public List<Topic> getTopics(){
		return topics;
	}
	
	public Topic getTopic(String id){
		
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if( t.getId().equals(id)) 
				return t;
		}
		return null;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void udpateTopic(Topic topic, String id) {
		
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if( t.getId().equals(id) ) {
				topics.set(i,topic);
				return;
			}
		}
	}

	public String deleteTopic(String id) {
		
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if( t.getId().equals(id) ) {
				topics.remove(i);  // deleting the i'th object whose ID is equal to id
				break;
			}
		}
		return "deleted";
		
		/*
		 * If the id is integer then the bellow code should work
		 * Topic t = topics.get(id);
		 * topics.remove(t);
		*/
	}
	
	
}
