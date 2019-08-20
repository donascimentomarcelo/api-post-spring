package br.com.wikicode.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User extends ObjectBase {

	// @Column(unique=true)
	private String username;
	private String password;
	@DBRef
	private Client client;
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}
