package br.com.wikicode.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.dto.DashboardDto;
import br.com.wikicode.reposiroty.CategoryRepository;
import br.com.wikicode.reposiroty.SubcategoryRepository;
import br.com.wikicode.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SubcategoryRepository subcategoryRepository;
	
	//@Autowired
	//private PostRepository postrepository;
	
	@Override
	public DashboardDto getDashboard() {
		Long qtdCategories = categoryRepository.count();
		Long qtdSubcategories = subcategoryRepository.count();
		Long qtdWikis = (long) 45;//postrepository.count();
		return new DashboardDto(qtdCategories, qtdSubcategories, qtdWikis);
	}

}
