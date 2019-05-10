package br.com.wikicode.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
