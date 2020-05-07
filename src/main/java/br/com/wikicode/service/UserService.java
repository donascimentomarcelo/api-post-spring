package br.com.wikicode.service;

import java.util.List;

import br.com.wikicode.config.security.UserSpringSecurity;
import br.com.wikicode.domain.User;

public interface UserService {

	List<User> findAll();
	User save(User user);
	UserSpringSecurity authenticated();
}
