package br.com.wikicode.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.wikicode.domain.Category;

public interface CategoryService {

	List<Category> all();
	Category save(Category category);
	void update(Category category, String id);
	Category find(String id);
	void delete(String id);
	Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);
}
