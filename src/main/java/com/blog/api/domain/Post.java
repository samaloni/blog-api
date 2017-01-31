package com.blog.api.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Post {
	
	private Long id;
	
	@NotNull
	private String content;
	
	private String type;
	
	@NotNull
	private String username;
	
	private List<Comment> comments;
	
	public Post() {
		comments = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
