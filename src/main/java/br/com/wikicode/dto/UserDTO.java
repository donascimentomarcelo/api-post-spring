package br.com.wikicode.dto;

import br.com.wikicode.domain.User;

public class UserDTO {

	private String username;
	
	public UserDTO() {
		super();
	}

	public UserDTO(User user) {
		super();
		this.username = user.getUsername();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
