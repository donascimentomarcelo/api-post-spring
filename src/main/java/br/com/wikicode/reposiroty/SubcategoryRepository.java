package br.com.wikicode.reposiroty;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.wikicode.domain.Subcategory;

@Repository
public interface SubcategoryRepository extends MongoRepository<Subcategory, String>{

	// @Query("SELECT bean from Subcategory bean WHERE bean.category.id = :id")
	// List<Subcategory> subcategoriesWhereHasCategoryId(@Param("id") String id);

}