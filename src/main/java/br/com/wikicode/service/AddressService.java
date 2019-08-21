package br.com.wikicode.service;

import java.util.List;

import br.com.wikicode.domain.Address;
import br.com.wikicode.domain.User;

public interface AddressService {
	void save(User user, List<Address> listAddress);
}
