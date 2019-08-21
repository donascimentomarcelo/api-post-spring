package br.com.wikicode.service;

import java.util.List;

import br.com.wikicode.domain.Address;
import br.com.wikicode.domain.Client;
import br.com.wikicode.domain.User;

public interface ClientService {
	void save(User user, List<Address> listAddress, Client client);
}
