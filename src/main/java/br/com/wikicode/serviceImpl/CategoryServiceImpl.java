package br.com.wikicode.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Category;
import br.com.wikicode.exception.ObjectNotFoundException;
import br.com.wikicode.exception.UnprocessableEntityException;
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
		checkIfCategoryExists(category);
		return categoryRepository.save(category);
	}

	private void checkIfCategoryExists(Category category) {
		Category value = categoryRepository.findByName(category.getName());
		if (value != null) {
			throw new UnprocessableEntityException("Já existe uma categoria com essa descrição.");
		}
	}

	@Override
	public void update(Category category, Integer id) {
		checkIfCategoryExists(category);
		find(id);
		category.setId(id);
		categoryRepository.save(category);
	}
	
	@Override
	public Category find(Integer id) {
		Category category = categoryRepository.findOne(id);
		if (category == null) {
			throw new ObjectNotFoundException("Categoria não encontrada.");
		}
		return category;
	}

	@Override
	public void delete(Integer id) {
		Category category = find(id);
		categoryRepository.delete(category);
	}

}
