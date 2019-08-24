package br.com.wikicode.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.wikicode.dto.WikiDTO;

@Document(collection="wiki")
public class Wiki extends ObjectBase {
	
	private String title;
	
	// @OneToMany(mappedBy="wiki")
	@DBRef(lazy=true)
	private List<Text> texts = new ArrayList<>();
	// @ManyToOne
	// @JoinColumn(name="client_id")
	@JsonIgnore
	private Client client;
	
	public Wiki() {
		
	}

	public Wiki(String title) {
		this.title = title;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public static Wiki fromWiki(WikiDTO wikiDto) {
		Wiki wiki = new Wiki();
		wiki.setTitle(wikiDto.getTitle());
		return wiki;
	}
	
}
