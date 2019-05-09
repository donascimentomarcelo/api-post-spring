package br.com.wikicode.service;

import java.util.List;

import br.com.wikicode.domain.Subcategory;

public interface SubcategoryService {

	List<Subcategory> all();
	Subcategory create(Subcategory subcategory);

}
