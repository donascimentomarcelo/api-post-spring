package br.com.wikicode.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Wiki;
import br.com.wikicode.reposiroty.WikiRepository;
import br.com.wikicode.service.WikiService;

@Service
public class WikiServiceImpl implements WikiService {

	@Autowired
	private WikiRepository wikiRepository;
	
	@Override
	public List<Wiki> list() {
		return wikiRepository.findAll();
	}

}
