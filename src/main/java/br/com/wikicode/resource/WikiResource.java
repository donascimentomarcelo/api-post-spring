package br.com.wikicode.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wikicode.domain.Wiki;
import br.com.wikicode.service.WikiService;

@RestController
@RequestMapping("/api/wikis")
public class WikiResource {

	@Autowired
	private WikiService wikiService;
	
	@GetMapping
	public ResponseEntity<List<Wiki>> list() {
		List<Wiki> list = wikiService.list();
		return ResponseEntity.ok(list);
	}
}
