package br.com.wikicode.reposiroty;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.wikicode.domain.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
	@Transactional(readOnly=true)
	Category findByName(String name);

}
