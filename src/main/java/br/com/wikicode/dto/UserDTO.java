package br.com.wikicode.dto;

import br.com.wikicode.domain.User;

public class UserDTO {

	private String username;
	private ClientDTO client;
	
	public UserDTO() {
		super();
	}

	public UserDTO(User user) {
		super();
		this.username = user.getUsername();
		this.client = new ClientDTO(user.getClient());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

}
