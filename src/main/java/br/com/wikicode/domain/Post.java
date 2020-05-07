package br.com.wikicode.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String title;
	private String description;
	private Integer vote;
	private Integer view;
	private Integer authorId;
	private String authorName;
	@DBRef(lazy=true)
	private List<Comment> comments = new ArrayList<Comment>();
	private Subcategory subcategory;
	private Date createdAt;
	private Date udatedAt;

	public Post(String title, String description, Integer vote, Integer view, Integer authorId, String authorName, Subcategory subcategory, Date createdAt, Date udatedAt) {
		this.title = title;
		this.description = description;
		this.vote = vote;
		this.view = view;
		this.authorId = authorId;
		this.authorName = authorName;
		this.subcategory = subcategory;
		this.createdAt = createdAt;
		this.udatedAt = udatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUdatedAt() {
		return udatedAt;
	}

	public void setUdatedAt(Date udatedAt) {
		this.udatedAt = udatedAt;
	}
}
