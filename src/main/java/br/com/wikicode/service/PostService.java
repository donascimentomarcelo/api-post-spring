package br.com.wikicode.service;

import java.util.List;

import br.com.wikicode.domain.Post;

public interface PostService {

	List<Post> getAll();

	Post save(Post dto);

	Post findOne(String id);

	void update(String id, Post post);

	void delete(String id);

}
