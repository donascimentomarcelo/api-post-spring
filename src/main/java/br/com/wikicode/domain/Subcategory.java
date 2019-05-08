package br.com.wikicode.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Subcategory extends ObjectBase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="category_id")
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
