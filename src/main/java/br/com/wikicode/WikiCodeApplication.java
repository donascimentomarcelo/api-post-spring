package br.com.wikicode;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import br.com.wikicode.domain.Comment;
import br.com.wikicode.domain.Post;
import br.com.wikicode.reposiroty.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wikicode.domain.Category;
import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.reposiroty.CategoryRepository;
import br.com.wikicode.reposiroty.PostRepository;
import br.com.wikicode.reposiroty.SubcategoryRepository;

@SpringBootApplication
public class WikiCodeApplication implements CommandLineRunner {

	private final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
	private final String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SubcategoryRepository subcategoryRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WikiCodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		categoryRepository.deleteAll();
		subcategoryRepository.deleteAll();
		postRepository.deleteAll();
		commentRepository.deleteAll();
		
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

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date date1 = sdf.parse("31-08-2019 10:20:56");
		Date date2 = sdf.parse("20-07-2019 09:10:50");

		Comment comment1 = new Comment(1, "Marta Felix", comment, date1);
		Comment comment2 = new Comment(1, "Joseph Bale", comment, date2);

		commentRepository.save(
				Arrays.asList(comment1, comment2)
		);

		Post postJava = new Post("Java Post", text, 10, 50, 1, "Crane", java, new Date(), new Date());
		Post postPHP = new Post("PHP Post", text, 15, 20, 1, "Crane", php, new Date(), new Date());
		Post postPython = new Post("Python Post", text, 84, 140, 1, "Crane", python, new Date(), new Date());
		Post postNode = new Post("Node Post", text, 2, 18, 1, "Crane", node, new Date(), new Date());

		postJava.setComments(Arrays.asList(comment1, comment2));
		postPython.setComments(Arrays.asList(comment1, comment2));

		postRepository.save(
				Arrays.asList(
						postJava, postPHP, postPython, postNode
				)
		);
	}

}
