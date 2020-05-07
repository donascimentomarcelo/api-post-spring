package br.com.wikicode.domain;

import java.util.HashSet;
import java.util.Set;

//@Document(collection="user")
public class User {

	private Integer id;
	private String username;
	private String password;
	private Set<String> profiles = new HashSet<>();
//	@DBRef
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

	public Set<String> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<String> profiles) {
		this.profiles = profiles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
