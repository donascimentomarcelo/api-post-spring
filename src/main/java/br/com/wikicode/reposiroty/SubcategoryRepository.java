package br.com.wikicode.reposiroty;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.reposiroty.query.SubcategoryRepositoryQuery;

@Repository
public interface SubcategoryRepository extends MongoRepository<Subcategory, String>, SubcategoryRepositoryQuery {

	List<Subcategory> findByCategory(String id);

	// @Query("SELECT bean from Subcategory bean WHERE bean.category.id = :id")
	// List<Subcategory> subcategoriesWhereHasCategoryId(@Param("id") String id);

}