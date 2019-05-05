package br.com.wikicode.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wikicode.domain.Category;
import br.com.wikicode.service.CategoryService;

@RestController
@RequestMapping("/api/users")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<?> listAll() {
		List<Category> list = categoryService.all();
		return ResponseEntity.ok().body(list);
	}
}
