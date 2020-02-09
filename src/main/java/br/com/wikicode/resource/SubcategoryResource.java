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

import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.dto.SubcategoryDTO;
import br.com.wikicode.service.BaseService;
import br.com.wikicode.service.SubcategoryService;

@RestController
@RequestMapping("/api/subcategories")
public class SubcategoryResource {
	
	@Autowired
	private SubcategoryService subcategoryService;

	@Autowired
	private BaseService baseService;

	@GetMapping
	public ResponseEntity<List<Subcategory>> list() {
		List<Subcategory> list = subcategoryService.all();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody SubcategoryDTO subcategoryDTO) {
		Subcategory subcategory = subcategoryService.associateWithCategory(subcategoryDTO);
		subcategory = subcategoryService.create(subcategory);
		URI uri = baseService.returnUri(subcategory.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody SubcategoryDTO subcategoryDTO, @PathVariable String id) {
		Subcategory subcategory = subcategoryService.associateWithCategory(subcategoryDTO);
		subcategoryService.update(subcategory, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		Subcategory subcategory = subcategoryService.find(id);
		subcategoryService.delete(subcategory);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SubcategoryDTO> find(@PathVariable String id) {
		Subcategory subcategory = subcategoryService.find(id);
		SubcategoryDTO dto = SubcategoryDTO.fromDto(subcategory);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/findByCategory/{id}")
	public ResponseEntity<List<Subcategory>> findByCategory(@PathVariable String id) {
		List<Subcategory> list = subcategoryService.findByCategory(id);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/paginate")
	public ResponseEntity<Page<Subcategory>> paginate(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Subcategory> subcategories = subcategoryService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(subcategories);
	}
	
	@GetMapping("/findByNameAndCategory")
	public ResponseEntity<List<Subcategory>> findByNameAndCategory(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "categoryId") String categoryId) {
		List<Subcategory> list = subcategoryService.findByNameAndCategory(name, categoryId);
		return ResponseEntity.ok().body(list);
	}
}
