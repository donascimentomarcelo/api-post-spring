package br.com.wikicode.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Text extends ObjectBase {

	private String message;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="wiki_id")
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
