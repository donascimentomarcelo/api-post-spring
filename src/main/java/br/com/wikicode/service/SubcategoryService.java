package br.com.wikicode.service;

import java.util.List;

import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.dto.SubcategoryDTO;

public interface SubcategoryService {

	List<Subcategory> all();
	Subcategory create(Subcategory subcategory);
	Subcategory associateWithCategory(SubcategoryDTO subcategoryDTO);

}
