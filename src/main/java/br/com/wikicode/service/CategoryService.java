package br.com.wikicode.service;

import java.util.List;

import br.com.wikicode.domain.Category;

public interface CategoryService {

	List<Category> all();
	Category save(Category category);
	void update(Category category, Integer id);
	
}
