package com.spring.boot.nosql;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tutorials")
public class Tutorial {
	
	@Id
	private String id;
	private String title;

	public Tutorial() {

	}

	public Tutorial(String id, String title) {
		this.id = id;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + "]";
	}
	
	
	
}
