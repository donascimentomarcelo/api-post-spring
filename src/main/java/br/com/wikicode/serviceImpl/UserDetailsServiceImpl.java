package br.com.wikicode.serviceImpl;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.wikicode.config.security.UserSpringSecurity;
import br.com.wikicode.domain.User;
import br.com.wikicode.service.IntegrationService;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private IntegrationService integrationService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    
	    User user = null;
		try {
			user = integrationService.authentication(username);
		} catch (URISyntaxException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return new UserSpringSecurity(user.getId(), user.getUsername(), user.getPassword(), user.getClient().getName(), user.getClient().getEmail(), user.getProfiles());
	}
}
