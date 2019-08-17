package br.com.wikicode.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wikicode.domain.Category;
import br.com.wikicode.service.BaseService;
import br.com.wikicode.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> find(@PathVariable String id) {
		Category category = categoryService.find(id);
		return ResponseEntity.ok(category);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Category category) {
		category = categoryService.save(category);
		URI uri  = baseService.returnUri(category.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Category category, @PathVariable String id) {
		categoryService.update(category, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/paginate")
	public ResponseEntity<Page<Category>> paginate(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Category> categories = categoryService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(categories);
	}
}
