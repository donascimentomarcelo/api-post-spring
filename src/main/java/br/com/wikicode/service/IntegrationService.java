package br.com.wikicode.service;

import java.net.URISyntaxException;

import br.com.wikicode.domain.User;

public interface IntegrationService {

	User authentication(String username) throws URISyntaxException;

}
