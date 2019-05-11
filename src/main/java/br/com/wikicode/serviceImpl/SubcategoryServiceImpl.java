package br.com.wikicode.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Category;
import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.dto.SubcategoryDTO;
import br.com.wikicode.exception.ObjectNotFoundException;
import br.com.wikicode.reposiroty.SubcategoryRepository;
import br.com.wikicode.service.CategoryService;
import br.com.wikicode.service.SubcategoryService;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

	@Autowired
	private SubcategoryRepository subcategoryRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public List<Subcategory> all() {
		return subcategoryRepository.findAll();
	}

	@Override
	public Subcategory create(Subcategory subcategory) {
		return subcategoryRepository.save(subcategory);
	}

	@Override
	public Subcategory associateWithCategory(SubcategoryDTO subcategoryDTO) {
		Category category = categoryService.find(subcategoryDTO.getCategoryId());
		Subcategory subcategory = new Subcategory(subcategoryDTO.getName(), category);
		return subcategory;
	}

	@Override
	public void update(Subcategory subcategory, Integer id) {
		subcategory.setId(id);
		subcategoryRepository.save(subcategory);
	}

	@Override
	public Subcategory find(Integer id) {
		Subcategory subcategory = subcategoryRepository.findOne(id);
		
		if (subcategory == null) {
			throw new ObjectNotFoundException("Subcategoria não encontrada.");
		}
		
		return subcategory;
	}

	@Override
	public void delete(Subcategory subcategory) {
		subcategoryRepository.delete(subcategory);
	}

	@Override
	public List<Subcategory> subcategoriesWhereHasCategoryId(Integer id) {
		return subcategoryRepository.subcategoriesWhereHasCategoryId(id);
	}

}
