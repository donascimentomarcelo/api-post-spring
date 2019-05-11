package br.com.wikicode.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wikicode.domain.Subcategory;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer>{

	@Query("SELECT bean from Subcategory bean WHERE bean.category.id = :id")
	List<Subcategory> subcategoriesWhereHasCategoryId(@Param("id") Integer id);

}