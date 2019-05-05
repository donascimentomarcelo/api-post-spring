package br.com.wikicode.serviceImpl;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.wikicode.domain.ObjectBase;
import br.com.wikicode.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService {

	public URI returnUri(ObjectBase object) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(object.getId()).toUri();
	}
}
