package br.com.wikicode.dto;

public class SubcategoryDTO {
	
	private String name;
	private Integer categoryId;
	
	public SubcategoryDTO() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}
