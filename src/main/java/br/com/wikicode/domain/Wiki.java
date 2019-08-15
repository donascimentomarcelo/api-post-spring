package br.com.wikicode.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Wiki extends ObjectBase {
	
	private String title;
	
	@OneToMany(mappedBy="wiki")
	private List<Text> texts = new ArrayList<>();
	
	public Wiki() {
		
	}

	public Wiki(String title, List<Text> texts) {
		this.title = title;
		this.texts = texts;
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
