package br.com.wikicode.reposiroty;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.wikicode.domain.Wiki;

public interface WikiRepository extends MongoRepository<Wiki, String>{

}
