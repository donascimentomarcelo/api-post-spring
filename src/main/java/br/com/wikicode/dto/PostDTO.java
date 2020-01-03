package br.com.wikicode.dto;

import java.io.Serializable;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String title;
	private String description;
	private String subcategoryId;
	
	public PostDTO(String title, String description, String subcategoryId) {
		this.title = title;
		this.description = description;
		this.subcategoryId = subcategoryId;
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
	public String getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
}
