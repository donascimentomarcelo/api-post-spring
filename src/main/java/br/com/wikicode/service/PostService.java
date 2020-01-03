package br.com.wikicode.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.wikicode.domain.Post;

public interface PostService {

	List<Post> getAll();

	Post save(Post dto);

	Post findOne(String id);

	void update(String id, Post post);

	void delete(String id);

	Page<Post> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);

}
