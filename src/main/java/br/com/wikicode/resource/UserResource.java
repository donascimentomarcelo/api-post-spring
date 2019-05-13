package br.com.wikicode.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wikicode.domain.User;
import br.com.wikicode.dto.UserDTO;
import br.com.wikicode.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> users = userService.findAll();
		
		List<UserDTO> usersDto = users
				.stream()
				.map(x -> new UserDTO(x))
				.collect(Collectors.toList());
	
		return ResponseEntity.ok(usersDto);
	}
}
