package br.com.wikicode.reposiroty.query;

import java.util.List;

import br.com.wikicode.domain.Subcategory;

public interface SubcategoryRepositoryQuery {

	List<Subcategory> filter(String name, String icon, String categoryId);
}
