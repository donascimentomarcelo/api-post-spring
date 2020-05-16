package br.com.wikicode.serviceImpl;

import java.util.Date;
import java.util.List;

import br.com.wikicode.config.security.UserSpringSecurity;
import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.dto.PostDTO;
import br.com.wikicode.service.SubcategoryService;
import br.com.wikicode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Post;
import br.com.wikicode.reposiroty.PostRepository;
import br.com.wikicode.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private SubcategoryService subcategoryService;

	@Autowired
	private UserService userService;

	@Override
	public List<Post> getAll() {
		return postRepository.findAll();
	}

	@Override
	public Post save(PostDTO dto) {
		Subcategory subcategory = subcategoryService.find(dto.getSubcategoryId());
		UserSpringSecurity authenticated = userService.authenticated();
		Post post = new Post(dto.getTitle(), dto.getDescription(), 0, 0, authenticated.getId(), authenticated.getUsername(), subcategory, new Date(), new Date());
		return postRepository.save(post);
	}

	@Override
	public Post findOne(String id) {
		return postRepository.findOne(id);
	}

	@Override
	public void update(Post post) {
		postRepository.save(post);
	}

	@Override
	public void delete(String id) {
		postRepository.delete(id);
	}

	@Override
	public Page<Post> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return postRepository.findAll(pageRequest);
	}

	@Override
	public List<Post> findByTitle(String categoryId, String subcategoryId, String title) {
		return postRepository.findByTitle(categoryId, subcategoryId, title);
	}

	

}
