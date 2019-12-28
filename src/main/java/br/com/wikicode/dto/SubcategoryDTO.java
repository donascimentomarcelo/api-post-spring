package br.com.wikicode.dto;

import br.com.wikicode.domain.Subcategory;

public class SubcategoryDTO {
	
	private String name;
	private String categoryId;
	
	public SubcategoryDTO() {

	}
	
	public SubcategoryDTO(String name, String categoryId) {
		this.name = name;
		this.categoryId = categoryId;
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

	public static SubcategoryDTO fromDto(Subcategory subcategory) {
		return new SubcategoryDTO(subcategory.getName(), subcategory.getCategory().getId());
	}
}
