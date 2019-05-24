package br.com.wikicode.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.User;
import br.com.wikicode.exception.UnprocessableEntityException;
import br.com.wikicode.reposiroty.UserRepository;
import br.com.wikicode.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		checkIfUserExists(user.getUsername());
		return userRepository.save(user);
	}
	
	public void checkIfUserExists(String username) {
		User user = userRepository.findByUsername(username);
		
		if(user != null) {
			throw new UnprocessableEntityException("Já existe um usuário com esse login.");
		}
	}
	

}
