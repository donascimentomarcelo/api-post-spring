package br.com.wikicode.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.wikicode.domain.Category;

public class CategoryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "The field NAME must be filled!")
	@Length(min=5, max=80, message = "In field NAME, the size should be between 5 and 80 characters!")
	private String name;
	
	@NotEmpty(message = "The field DESCRIPTION must be filled!")
	@Length(min=5, max=80, message = "In field DESCRIPTION, the size should be between 5 and 80 characters!")
	private String description;

	public CategoryDto(Category category) {
		this.name = category.getName();
	}

	public CategoryDto() {

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

	public static Category fromDto(CategoryDto dto) {
		return new Category(dto.getName(), dto.getDescription());
	}

	public static CategoryDto fromDto(Category category) {
		return new CategoryDto(category);
	}
}
