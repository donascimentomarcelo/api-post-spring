package br.com.wikicode.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.reposiroty.SubcategoryRepository;
import br.com.wikicode.service.SubcategoryService;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

	@Autowired
	private SubcategoryRepository subcategoryRepository;
	
	@Override
	public List<Subcategory> all() {
		return subcategoryRepository.findAll();
	}

}
