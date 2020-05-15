package br.com.wikicode.dto;

import br.com.wikicode.config.security.UserSpringSecurity;
import br.com.wikicode.domain.User;

public class UserDTO {

	private Integer id;
	private String username;
	private String name;
	private String email;
	private ClientDTO client;
	
	public UserDTO() {

	}

	public UserDTO(User user) {
		this.username = user.getUsername();
		this.client = new ClientDTO(user.getClient());
	}

	public UserDTO(UserSpringSecurity user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.name = user.getName();
		this.email = user.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
