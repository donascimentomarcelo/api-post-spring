package br.com.wikicode.serviceImpl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.wikicode.config.security.UserSpringSecurity;
import br.com.wikicode.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public UserSpringSecurity authenticated() {
		try {
			return (UserSpringSecurity) SecurityContextHolder
						.getContext()
						.getAuthentication()
						.getPrincipal();
		
		} catch (Exception e) {
			return null;
		}
	}

}
