package br.com.wikicode.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.wikicode.domain.Category;

public interface CategoryService {

	List<Category> all();
	Category save(Category category);
	void update(Category category, Integer id);
	Category find(Integer id);
	void delete(Integer id);
	Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);
	
}
