package br.com.wikicode.domain;

import java.io.Serializable;

/**
 * @Author Marcelo Nascimento
 * @Date 4 de mai de 2019
 * @Project WikiCode
 * @Package br.com.wikicode.domain
 * @Desc 
 */
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	
	public Category(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Category() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
