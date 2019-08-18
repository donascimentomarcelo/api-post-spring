package br.com.wikicode;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wikicode.domain.Category;
import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.domain.User;
import br.com.wikicode.reposiroty.CategoryRepository;
import br.com.wikicode.reposiroty.SubcategoryRepository;
import br.com.wikicode.reposiroty.UserRepository;

@SpringBootApplication
public class WikiCodeApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SubcategoryRepository subcategoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WikiCodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		categoryRepository.deleteAll();
		subcategoryRepository.deleteAll();
		userRepository.deleteAll();
		
		
		Category c1 = new Category("Desenvolvimento Web");
		Category c2 = new Category("Desenvolvimento Mobile");
		Category c3 = new Category("Desenvolvimento Desktop");
		Category c4 = new Category("Banco de Dados");
		categoryRepository.save(Arrays.asList(c1, c2, c3, c4));
		
		Subcategory s1 = new Subcategory("Java", c1);
		Subcategory s2 = new Subcategory("PHP", c1);
		Subcategory s3 = new Subcategory("NodeJS", c1);
		subcategoryRepository.save(Arrays.asList(s1, s2, s3));
		
		c1.getSubcategories().addAll(Arrays.asList(s1, s2, s3));
		categoryRepository.save(c1);
		
		User u1 = new User("crane@email", "1234");
		userRepository.save(u1);
	}

}
