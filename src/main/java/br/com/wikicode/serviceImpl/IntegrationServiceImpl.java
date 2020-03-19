package br.com.wikicode.serviceImpl;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.wikicode.domain.User;
import br.com.wikicode.service.IntegrationService;

@Service
public class IntegrationServiceImpl implements IntegrationService {
	
	@Value("${integration.userserviceUrl.login}")
	private String userserviceUrl;

	@Override
	public User authentication(String username) throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    URI uri = new URI(userserviceUrl);
	 
		ResponseEntity<User> result = restTemplate.getForEntity(String.format("%s?username=%s", uri, username), User.class);

	    return result.getBody();
	}

}
