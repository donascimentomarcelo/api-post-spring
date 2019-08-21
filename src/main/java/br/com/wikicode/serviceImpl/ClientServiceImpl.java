package br.com.wikicode.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Address;
import br.com.wikicode.domain.Client;
import br.com.wikicode.domain.User;
import br.com.wikicode.domain.enums.Profile;
import br.com.wikicode.reposiroty.ClientRepository;
import br.com.wikicode.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clienteRepository;

	@Override
	public void save(User user, List<Address> listAddress, Client client) {
		addingAddressToClient(listAddress, client);
		addingPhoneToClient(user, client);		
		addingProfileToClient(user, client);
		clienteRepository.save(client);
	}

	private void addingAddressToClient(List<Address> listAddress, Client client) {
		client.getAddress().addAll(listAddress);
	}

	private void addingPhoneToClient(User user, Client client) {
		client.getPhones().addAll(user.getClient().getPhones());
	}

	private void addingProfileToClient(User user, Client client) {
		for (Profile profile : user.getClient().getProfiles()) {
			client.addProfile(profile);			
		}
	}
}
