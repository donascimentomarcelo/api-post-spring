package br.com.wikicode.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wikicode.domain.Subcategory;
import br.com.wikicode.service.SubcategoryService;

@RestController
@RequestMapping("/api/subcategories")
public class SubcategoryResource {
	
	@Autowired
	private SubcategoryService subcategoryService;

	@GetMapping
	public ResponseEntity<List<Subcategory>> list() {
		List<Subcategory> list = subcategoryService.all();
		return ResponseEntity.ok().body(list);
	}
}
