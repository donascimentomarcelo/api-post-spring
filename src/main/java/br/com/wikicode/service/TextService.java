package br.com.wikicode.service;

import br.com.wikicode.domain.Text;
import br.com.wikicode.dto.TextDTO;

public interface TextService {

	Text save(TextDTO text);

}
