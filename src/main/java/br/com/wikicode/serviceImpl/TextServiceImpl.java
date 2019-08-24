package br.com.wikicode.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Text;
import br.com.wikicode.dto.TextDTO;
import br.com.wikicode.reposiroty.TextRepository;
import br.com.wikicode.service.TextService;

@Service
public class TextServiceImpl implements TextService {

	@Autowired
	private TextRepository textRepository;
	
	@Override
	public Text save(TextDTO textDto) {
		Text text = Text.fromText(textDto);
		return textRepository.save(text);
	}

}
