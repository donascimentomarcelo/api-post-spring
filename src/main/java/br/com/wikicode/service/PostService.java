package br.com.wikicode.service;

import java.util.List;

import br.com.wikicode.dto.PostDTO;
import org.springframework.data.domain.Page;

import br.com.wikicode.domain.Post;

public interface PostService {

	List<Post> getAll();

	Post save(PostDTO dto);

	Post findOne(String id);

	void update(Post post);

	void delete(String id);

	Page<Post> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);

	List<Post> findByTitle(String categoryId, String subcategoryId, String title);

}
