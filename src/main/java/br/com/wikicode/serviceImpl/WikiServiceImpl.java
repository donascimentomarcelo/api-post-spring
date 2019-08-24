package br.com.wikicode.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wikicode.domain.Text;
import br.com.wikicode.domain.Wiki;
import br.com.wikicode.dto.WikiDTO;
import br.com.wikicode.reposiroty.WikiRepository;
import br.com.wikicode.service.TextService;
import br.com.wikicode.service.WikiService;

@Service
public class WikiServiceImpl implements WikiService {

	@Autowired
	private WikiRepository wikiRepository;
	
	@Autowired
	private TextService textService;
	
	@Override
	public List<Wiki> list() {
		return wikiRepository.findAll();
	}

	@Override
	public Wiki save(WikiDTO wikiDto) {
		List<Text> textList = new ArrayList<>();
		associatingTextToList(wikiDto, textList);
		Wiki wiki = Wiki.fromWiki(wikiDto);
		wiki.getTexts()
			.addAll(textList);
		return wikiRepository.save(wiki);
	}

	private void associatingTextToList(WikiDTO wikiDto, List<Text> textList) {
		wikiDto.getTexts()
			.stream()
			.forEach(text -> {
				Text newText = textService.save(text);
				textList.add(newText);
			});
	}

}
