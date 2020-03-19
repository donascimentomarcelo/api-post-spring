package br.com.wikicode.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.wikicode.domain.enums.Profile;

//@Document(collection="client")
public class Client extends ObjectBase {
	
	private String name;
	private String email;
//	@DBRef(lazy=true)
	private List<Address> address = new ArrayList<>();
	private Set<String> phones = new HashSet<>();
	private Set<Integer> profiles = new HashSet<>();
	//private List<Post> wiki = new ArrayList<>();

	public Client() {
		super();
	}

	public Client(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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

	public Set<Profile> getProfiles() {
		return profiles
				.stream()
				.map(profile -> Profile.toEnum(profile))
				.collect(Collectors.toSet());
	}
	
	public void addProfile(Profile profile) {
		this.profiles.add(profile.getCode());
	}

	public void setProfiles(Set<Integer> profiles) {
		this.profiles = profiles;
	}	
}
