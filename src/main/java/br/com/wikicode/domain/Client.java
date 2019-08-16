package br.com.wikicode.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends ObjectBase {
	
	private String name;
	private String email;
	
	@OneToMany(mappedBy="client")
	private List<Address> address = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="PHONES")
	private Set<String> phones = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name="PROFILES")
	private Set<Integer> profiles = new HashSet<>();
	
	@OneToMany(mappedBy="client")
	private List<Wiki> wiki = new ArrayList<>();

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

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Set<Integer> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Integer> profiles) {
		this.profiles = profiles;
	}

	public List<Wiki> getWiki() {
		return wiki;
	}

	public void setWiki(List<Wiki> wiki) {
		this.wiki = wiki;
	}
}
