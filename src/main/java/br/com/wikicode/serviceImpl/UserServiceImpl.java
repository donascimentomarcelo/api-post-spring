package br.com.wikicode.serviceImpl;

import br.com.wikicode.config.security.UserSpringSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.wikicode.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserSpringSecurity authenticated() {
		try {
			return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
