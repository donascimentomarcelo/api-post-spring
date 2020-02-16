package br.com.wikicode.reposiroty.query;

import java.util.List;

import br.com.wikicode.domain.Post;

public interface PostRepositoryQuery {
	
	List<Post> findByTitle(String categoryId, String subcategoryId, String title);
}
