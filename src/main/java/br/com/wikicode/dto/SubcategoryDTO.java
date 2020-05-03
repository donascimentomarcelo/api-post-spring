package br.com.wikicode.dto;

import br.com.wikicode.domain.Subcategory;

public class SubcategoryDTO {
	
	private String name;
	private String description;
	private String icon;
	private String categoryId;
	
	public SubcategoryDTO() {

	}
	
	public SubcategoryDTO(String name, String categoryId, String icon) {
		this.name = name;
		this.categoryId = categoryId;
		this.icon = icon;
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

	public static SubcategoryDTO fromDto(Subcategory subcategory) {
		return new SubcategoryDTO(subcategory.getName(), subcategory.getCategory().getId(), subcategory.getIcon());
	}
}
