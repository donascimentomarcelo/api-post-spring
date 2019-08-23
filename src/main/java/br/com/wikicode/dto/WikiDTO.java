package br.com.wikicode.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.wikicode.domain.Text;
import br.com.wikicode.domain.Wiki;

public class WikiDTO {
	private String title;
	private List<Text> texts = new ArrayList<>();

	public WikiDTO() {
		
	}

	public WikiDTO(Wiki wiki) {
		this.title = wiki.getTitle();
		this.texts = wiki.getTexts();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Text> getTexts() {
		return texts;
	}
	public void setTexts(List<Text> texts) {
		this.texts = texts;
	}
}
