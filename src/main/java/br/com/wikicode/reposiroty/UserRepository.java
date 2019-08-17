package br.com.wikicode.reposiroty;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.wikicode.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findByUsername(String username);

}
