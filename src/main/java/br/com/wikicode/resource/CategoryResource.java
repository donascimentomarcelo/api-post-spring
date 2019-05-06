package br.com.wikicode.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wikicode.domain.Category;
import br.com.wikicode.service.BaseService;
import br.com.wikicode.service.CategoryService;

@RestController
@RequestMapping("/api/users")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BaseService baseService;

	@GetMapping
	public ResponseEntity<List<Category>> list() {
		List<Category> list = categoryService.all();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Category category) {
		category = categoryService.save(category);
		URI uri  = baseService.returnUri(category);
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> update(@RequestBody Category category, @PathVariable Integer id) {
		categoryService.update(category, id);
		return ResponseEntity.noContent().build();
	}
}
