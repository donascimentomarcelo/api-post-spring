package br.com.wikicode.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wikicode.domain.Subcategory;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer>{

}
