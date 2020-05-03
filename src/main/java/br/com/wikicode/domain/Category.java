package br.com.wikicode.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="category")
public class Category extends ObjectBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String icon;
	
	public Category(String name, String description, String icon) {
		super();
		this.name = name;
		this.description = description;
		this.icon = icon;
	}
	
	public Category() {
		super();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
