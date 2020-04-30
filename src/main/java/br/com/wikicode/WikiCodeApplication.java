package br.com.wikicode;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wikicode.domain.Address;
import br.com.wikicode.domain.Category;
import br.com.wikicode.domain.Client;
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
		
		
		Category backend = new Category(
				"Backend", 
				"Em projetos de software, por exemplo, a arquitetura modelo-visão-controlador fornece o -end e o back-end para o banco de dados, o usuário e para os componentes de processamento. A separação de sistemas de software em front-end e back-end simplifica o desenvolvimento e separa a manutenção. ",
				"fas fa-server");
		Category frontend = new Category(
				"Frontend",
				"O front-end é responsável por coligir a entrada do usuário em várias formas e processá-la para adequá-la a uma especificação em que o back-end a possa utilizar",
				"fas fa-terminal");
		Category api = new Category(
				"API",
				"A sigla API provém do Inglês Application Programming Interface, é um conjunto de rotinas e padrões estabelecidos por um software para a utilização das suas funcionalidades por aplicativos que não pretendem envolver-se em detalhes da implementação do software, mas apenas usar seus serviços.",
				"fas fa-laptop-code");
		Category git = new Category(
				"Git",
				"É um sistema de controle de versões distribuído, usado principalmente no desenvolvimento de software, mas pode ser usado para registrar o histórico de edições de qualquer tipo de arquivo.",
				"fas fa-code-branch");
		Category infra = new Category(
				"Infra", 
				"Em projetos de software, por exemplo, a arquitetura modelo-visão-controlador fornece o -end e o back-end para o banco de dados, o usuário e para os componentes de processamento. A separação de sistemas de software em front-end e back-end simplifica o desenvolvimento e separa a manutenção. ",
				"fas fa-network-wired");
		Category database = new Category(
				"Database",
				"São conjuntos de arquivos relacionados entre si com registros sobre pessoas, lugares ou coisas.",
				"fas fa-database");
		
		categoryRepository.save(
				Arrays.asList(backend, frontend, api, git, infra, database)
		);

		
		Subcategory java = new Subcategory("Java", null, "fab fa-java", backend);
		Subcategory php = new Subcategory("PHP", null, "fab fa-php", backend);
		Subcategory python = new Subcategory("Python", null, "fab fa-python", backend);
		Subcategory node = new Subcategory("Node", null, "fab fa-node-js", backend);

		Subcategory angular = new Subcategory("Angular", null, "fab fa-angular", frontend);
		Subcategory js = new Subcategory("Javascript", null, "fab fa-js", frontend);
		Subcategory react = new Subcategory("React", null, "fab fa-react", frontend);
		Subcategory css = new Subcategory("CSS 3", null, "fab fa-css3", frontend);
		
		Subcategory spring = new Subcategory("Spring Boot", null, "fab fa-java", api);
		Subcategory laravel = new Subcategory("Laravel", null, "fab fa-php", api);

		Subcategory docker = new Subcategory("Docker", null, "fab fa-docker", infra);
		Subcategory aws = new Subcategory("AWS", null, "fab fa-aws", infra);
		Subcategory cloud = new Subcategory("Cloud", null, "fas fa-cloud", infra);
		
		subcategoryRepository.save(
				Arrays.asList(
						java, php, python, node,
						angular, js, react, css,
						spring, laravel,
						docker, aws, cloud)
		);
		
		
				
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
