package br.com.wikicode.dto;

import br.com.wikicode.domain.Text;

public class TextDTO {
	
	private String message;

	public TextDTO() {
	
	}
	
	public TextDTO(Text text) {
		this.message = text.getMessage();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
