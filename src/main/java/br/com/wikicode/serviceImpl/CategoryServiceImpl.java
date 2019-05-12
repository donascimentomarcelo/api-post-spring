package br.com.wikicode.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Category;
import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.exception.IntegrityViolationException;
import br.com.wikicode.exception.ObjectNotFoundException;
import br.com.wikicode.exception.UnprocessableEntityException;
import br.com.wikicode.reposiroty.CategoryRepository;
import br.com.wikicode.service.CategoryService;
import br.com.wikicode.service.SubcategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository; 
	
	@Autowired
	private SubcategoryService subcategoryService;
	
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
		
		List<Subcategory> subcategories = subcategoryService.subcategoriesWhereHasCategoryId(id);
		if (subcategories.size() != 0) {
			throw new IntegrityViolationException("Essa categoria possui dependencias.");
		}
		Category category = find(id);
		categoryRepository.delete(category);
	}

	@Override
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoryRepository.findAll(pageRequest);
	}

}
