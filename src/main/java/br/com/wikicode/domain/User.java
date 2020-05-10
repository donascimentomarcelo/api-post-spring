package br.com.wikicode.domain;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer id;
	private String username;
	private String password;
	private Set<String> profiles = new HashSet<>();
	private Client client;
	
	public User(String username, String password, Client client) {
		this.username = username;
		this.password = password;
		this.client = client;
	}
	
	public User() {

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
}
