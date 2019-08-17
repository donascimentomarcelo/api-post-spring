package br.com.wikicode.dto;

public class SubcategoryDTO {
	
	private String name;
	private String categoryId;
	
	public SubcategoryDTO() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}
