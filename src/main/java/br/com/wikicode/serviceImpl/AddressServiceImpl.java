package br.com.wikicode.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Address;
import br.com.wikicode.domain.User;
import br.com.wikicode.reposiroty.AddressRepository;
import br.com.wikicode.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void save(User user, List<Address> listAddress) {
		for(Address address: user.getClient().getAddress()) {
			listAddress.add(address);
		}
		addressRepository.save(listAddress);
	}
}
