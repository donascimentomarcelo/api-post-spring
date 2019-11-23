package br.com.wikicode.dto;

import java.io.Serializable;

public class DashboardDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long categories;
	private Long subcategories;
	private Long wikis;
	
	public DashboardDto() {

	}

	public DashboardDto(Long categories, Long subcategories, Long wikis) {
		this.categories = categories;
		this.subcategories = subcategories;
		this.wikis = wikis;
	}

	public Long getCategories() {
		return categories;
	}

	public void setCategories(Long categories) {
		this.categories = categories;
	}

	public Long getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Long subcategories) {
		this.subcategories = subcategories;
	}

	public Long getWikis() {
		return wikis;
	}

	public void setWikis(Long wikis) {
		this.wikis = wikis;
	}
}
