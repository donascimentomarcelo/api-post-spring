package br.com.wikicode.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.wikicode.domain.Client;
import br.com.wikicode.domain.enums.Profile;

public class ClientDTO {
	
	private String name;
	private String email;
	private List<AddressDTO> address = new ArrayList<>();
	private Set<String> phones = new HashSet<>();
	private Set<Profile> profiles = new HashSet<>();

	public ClientDTO() {
		super();
	}

	public ClientDTO(Client client) {
		super();
		this.name = client.getName();
		this.email = client.getEmail();
		this.address = AddressDTO.fromAddressDTO(client);
		this.phones = client.getPhones();
		this.profiles = client.getProfiles();
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
	
	public List<AddressDTO> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDTO> address) {
		this.address = address;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
}
