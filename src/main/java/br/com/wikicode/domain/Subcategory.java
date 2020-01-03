package br.com.wikicode.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="subcategory")
public class Subcategory extends ObjectBase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;

	@DBRef(lazy=true)
	private Category category;
	
	public Subcategory(String name, Category category) {
		super();
		this.name = name;
		this.category = category;
	}

	public Subcategory() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
