package br.com.wikicode.dto;

import br.com.wikicode.domain.Client;
import br.com.wikicode.domain.User;

public class UserDTO {

	private String username;
	private Client client;
	
	public UserDTO() {
		super();
	}

	public UserDTO(User user) {
		super();
		this.username = user.getUsername();
		this.client = user.getClient();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
