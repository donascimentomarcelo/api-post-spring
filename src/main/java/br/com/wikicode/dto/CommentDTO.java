package br.com.wikicode.dto;

import java.io.Serializable;

public class CommentDTO implements Serializable {

    private Integer userId;
    private String userName;
    private String text;
    private String postId;

    public CommentDTO() {
    }

    public CommentDTO(Integer userId, String userName, String text, String postId) {
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
