package br.com.wikicode.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Category;
import br.com.wikicode.reposiroty.CategoryRepository;
import br.com.wikicode.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository; 
	
	@Override
	public List<Category> all() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void update(Category category, Integer id) {
		find(id);
		category.setId(id);
		categoryRepository.save(category);
	}
	
	@Override
	public Category find(Integer id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		Category category = find(id);
		categoryRepository.delete(category);
	}

}
