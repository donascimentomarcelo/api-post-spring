package br.com.wikicode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wikicode.domain.Category;
import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.reposiroty.CategoryRepository;
import br.com.wikicode.reposiroty.SubcategoryRepository;

@SpringBootApplication
public class WikiCodeApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SubcategoryRepository subcategoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WikiCodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category("Programação");
		
		Subcategory s1 = new Subcategory("Java", c1);
		
		categoryRepository.save(c1);
		subcategoryRepository.save(s1);
	}

}
