package br.com.wikicode.reposiroty;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.wikicode.domain.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, String>{

}
