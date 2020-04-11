package br.com.wikicode.service;

import br.com.wikicode.config.security.UserSpringSecurity;

public interface AuthService {

	UserSpringSecurity authenticated();

}
