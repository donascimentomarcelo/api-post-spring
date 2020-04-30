package br.com.wikicode.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="subcategory")
public class Subcategory extends ObjectBase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String icon;

	@DBRef(lazy=true)
	private Category category;

	public Subcategory(String name, String description, String icon, Category category) {
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.category = category;
	}

	public Subcategory(String id) {
		this.id = id;
	}

	public Subcategory() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
