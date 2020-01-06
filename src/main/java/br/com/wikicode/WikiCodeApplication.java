package br.com.wikicode;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wikicode.domain.Address;
import br.com.wikicode.domain.Category;
import br.com.wikicode.domain.Client;
import br.com.wikicode.domain.Post;
import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.domain.User;
import br.com.wikicode.domain.enums.Profile;
import br.com.wikicode.domain.enums.State;
import br.com.wikicode.reposiroty.AddressRepository;
import br.com.wikicode.reposiroty.CategoryRepository;
import br.com.wikicode.reposiroty.ClientRepository;
import br.com.wikicode.reposiroty.PostRepository;
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

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WikiCodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		categoryRepository.deleteAll();
		subcategoryRepository.deleteAll();
		postRepository.deleteAll();
		userRepository.deleteAll();
		clientRepository.deleteAll();
		addressRepository.deleteAll();
		
		for (int i = 0; i < 50; i++) {
			Category c5 = new Category(
					String.format("Categoria %s", (i + 1)), 
					String.format("Desc %s", (i + 1))
			);
			categoryRepository.save(c5);
			

			Subcategory s4 = new Subcategory(String.format("Subcategoria %s", (i + 1)), c5);
			subcategoryRepository.save(s4);
				

			Post p1 = new Post(
					null, 
					String.format("Post %s", (i + 1)), 
					String.format("Descrição %s", (i + 1)), s4);
			postRepository.save(p1);
							
		}
				
		User u1 = new User("k.crane", "1234");
		userRepository.save(u1);
		
		Address a1 = new Address("2012458", "rua abc", "Rio de Janeiro", State.RJ);
		Address a2 = new Address("1215515", "rua abc", "São Paulo", State.SP);
		Address a3 = new Address("8784584", "rua abc", "Minas Gerais", State.MG);
		addressRepository.save(Arrays.asList(a1, a2, a3));
		
		
		Client cli1 = new Client("Kyle Crane", "crane@email");
		cli1.getAddress().addAll(Arrays.asList(a1, a2, a3));
		cli1.getPhones().addAll(Arrays.asList("34553890", "982525286"));
		cli1.addProfile(Profile.ADMIN);
		clientRepository.save(Arrays.asList(cli1));
		
		u1.setClient(cli1);
		userRepository.save(u1);	
	}

}
