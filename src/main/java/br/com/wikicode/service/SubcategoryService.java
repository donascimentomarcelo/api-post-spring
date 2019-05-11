package br.com.wikicode.service;

import java.util.List;

import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.dto.SubcategoryDTO;

public interface SubcategoryService {

	List<Subcategory> all();
	Subcategory create(Subcategory subcategory);
	Subcategory associateWithCategory(SubcategoryDTO subcategoryDTO);
	void update(Subcategory subcategory, Integer id);
	Subcategory find(Integer id);
	void delete(Subcategory subcategory);
	List<Subcategory> subcategoriesWhereHasCategoryId(Integer id);

}
