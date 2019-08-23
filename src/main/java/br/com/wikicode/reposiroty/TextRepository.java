package br.com.wikicode.reposiroty;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.wikicode.domain.Text;

public interface TextRepository extends MongoRepository<Text, String>{

}
