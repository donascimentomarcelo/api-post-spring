package br.com.wikicode.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="text")
public class Text extends ObjectBase {

	private String message;
	
	// @ManyToOne
	@JsonIgnore
	// @JoinColumn(name="wiki_id")
	private Wiki wiki;

	public Text() {
	
	}
	
	public Text(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Wiki getWiki() {
		return wiki;
	}

	public void setWiki(Wiki wiki) {
		this.wiki = wiki;
	}
}
