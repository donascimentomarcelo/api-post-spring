package br.com.wikicode.service;

import java.util.List;

import br.com.wikicode.domain.Wiki;
import br.com.wikicode.dto.WikiDTO;

public interface WikiService {

	List<Wiki> list();
	Wiki save(WikiDTO wikiDto);

}
