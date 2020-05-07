package br.com.wikicode.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Integer userId;
    private String userName;
    private String text;

    public Comment(Integer userId, String userName, String text) {
        this.userId = userId;
        this.userName = userName;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
