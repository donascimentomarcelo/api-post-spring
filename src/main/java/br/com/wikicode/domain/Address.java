package br.com.wikicode.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.wikicode.domain.enums.State;

@Document(collection="address")
public class Address extends ObjectBase {
	
	private String zipcode;
	private String address;
	private String city;
	private Integer state;
	
	// @ManyToOne
	// @JoinColumn(name="client_id")
	@JsonIgnore
	private Client client;
	
	public Address() {
		
	}
	
	public Address(String zipcode, String address, String city, State state, Client client) {
		this.zipcode = zipcode;
		this.address = address;
		this.city = city;
		this.state = state != null ? state.getCode() : null;
		this.client = client;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public State getState() {
		return State.toEnum(this.state);
	}
	public void setState(State state) {
		this.state = state.getCode();
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
