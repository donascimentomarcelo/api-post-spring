package br.com.wikicode.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Category extends ObjectBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	@OneToMany(mappedBy="category")
	private List<Subcategory> subcategories = new ArrayList<>();
	
	public Category(String name) {
		super();
		this.name = name;
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
	public List<Subcategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
}
