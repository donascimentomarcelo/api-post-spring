package br.com.wikicode.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String title;
	private String description;
	private Subcategory subcategory;
	
	public Post(String id, String title, String description, Subcategory subcategory) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.subcategory = subcategory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}
}
