package br.com.wikicode.reposiroty;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.wikicode.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
