package br.com.wikicode.reposiroty;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.wikicode.domain.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String>{

}
