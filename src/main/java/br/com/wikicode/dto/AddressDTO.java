package br.com.wikicode.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.wikicode.domain.Address;
import br.com.wikicode.domain.Client;
import br.com.wikicode.domain.enums.State;

public class AddressDTO {
	
	private String zipcode;
	private String address;
	private String city;
	private Integer state;
	
	
	public AddressDTO() {
		
	}
	
	public AddressDTO(Address address) {
		this.zipcode = address.getZipcode();
		this.address = address.getAddress();
		this.city = address.getCity();
		this.state = address.getState().getCode() != null ? address.getState().getCode() : null;
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

	public static List<AddressDTO> fromAddressDTO(Client client) {
		return client.getAddress()
					 .stream()
					 .map(address -> new AddressDTO(address))
					 .collect(Collectors.toList());
	}
}
