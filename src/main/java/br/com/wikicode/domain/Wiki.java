package br.com.wikicode.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Wiki extends ObjectBase {
	
	private String title;
	
	@OneToMany(mappedBy="wiki")
	private List<Text> texts = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="client_id")
	@JsonIgnore
	private Client client;
	
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
