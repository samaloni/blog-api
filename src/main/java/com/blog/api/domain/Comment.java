package com.blog.api.domain;

import javax.validation.constraints.NotNull;

public class Comment {
	
	private Long id;
	
	@NotNull
	private String text;
	
	@NotNull
	private Long postId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
}
