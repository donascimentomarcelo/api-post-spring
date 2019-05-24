package br.com.wikicode.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wikicode.domain.User;
import br.com.wikicode.dto.UserDTO;
import br.com.wikicode.service.BaseService;
import br.com.wikicode.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BaseService baseService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> users = userService.findAll();
		
		List<UserDTO> usersDto = users
				.stream()
				.map(x -> new UserDTO(x))
				.collect(Collectors.toList());
	
		return ResponseEntity.ok(usersDto);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody User user){
		user = userService.save(user);
		URI uri = baseService.returnUri(user.getId());
		return ResponseEntity.created(uri).build();
	}
}
