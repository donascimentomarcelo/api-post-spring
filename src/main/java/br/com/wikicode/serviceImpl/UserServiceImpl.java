package br.com.wikicode.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wikicode.domain.Address;
import br.com.wikicode.domain.Client;
import br.com.wikicode.domain.User;
import br.com.wikicode.exception.UnprocessableEntityException;
import br.com.wikicode.reposiroty.UserRepository;
import br.com.wikicode.service.AddressService;
import br.com.wikicode.service.ClientService;
import br.com.wikicode.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClientService clientService;

	@Autowired
	private AddressService addressService;

	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly=false)
	public User save(User user) {
		checkIfUserExists(user.getUsername());
	
		List<Address> listAddress = new ArrayList<>();
		Client client = user.getClient();
		
		addressService.save(user, listAddress);
		clientService.save(user, listAddress, client);
		
		user.setClient(client);
		
		User newUser = userRepository.save(user);
		return newUser;
	}




	
	public void checkIfUserExists(String username) {
		User user = userRepository.findByUsername(username);
		
		if(user != null) {
			throw new UnprocessableEntityException("Já existe um usuário com esse login.");
		}
	}
	

}
