package com.blog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.domain.Comment;
import com.blog.api.domain.Post;
import com.blog.api.service.CommentService;
import com.blog.api.service.PostService;

@RestController
@RequestMapping(path="/posts/{id}/comments")
public class CommentController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Comment> list(@PathVariable Long id) {
		Post post = postService.getPost(id);
		return post.getComments();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Comment save(@Validated @RequestBody Comment comment) {
		commentService.addComment(comment);
		return comment;
	}

}
