package com.blog.api;

import static org.testng.Assert.*;

import org.apache.http.entity.ContentType;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;

import com.blog.api.domain.Comment;
import com.blog.api.domain.Post;
import com.blog.api.domain.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class BlogApiApplicationTests {

	
	
	@Test
	public void test_post_users_api() {
		HttpResponse<JsonNode> jsonResponse;
		
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user.setFirstName("Sarah");
		user.setLastName("Palin");
		user.setUsername("s.palin");
		
		try {
			JsonNode body = new JsonNode(mapper.writeValueAsString(user));
			jsonResponse = Unirest.post("http://localhost:8080/blog/api/users")
					  .header("accept", MediaType.APPLICATION_JSON_VALUE)
					  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					  .body(body)
					  .asJson();
			JSONObject responseBody = jsonResponse.getBody().getObject();
			assertNotNull(jsonResponse.getBody());
			assertEquals(responseBody.getString("firstName"), user.getFirstName());		//add user test case 
			
			assertEquals(responseBody.getString("lastName"), user.getLastName());
			assertEquals(responseBody.getString("username"), user.getUsername());
			assertEquals(jsonResponse.getStatus(),200);
			
			
			// add test cases for get post put  delete and null username
			
		} catch (UnirestException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
	
		@Test
		public void test_posts_api(){
			
			HttpResponse<JsonNode> jsonPosts = null;
			
			ObjectMapper mapper = new ObjectMapper();
			User user = new User();
			user.setFirstName("Sarah");
			user.setLastName("Palin");
			user.setUsername("s.palin");
			
			Post post = new Post();
			post.setContent("Comment for post");
			post.setType("type post");
			post.setUsername("saloni");
			
			
		try{
			JsonNode body = new JsonNode(mapper.writeValueAsString(post));
			jsonPosts = Unirest.post("http://localhost:8080/blog/api/posts")
					  .header("accept", MediaType.APPLICATION_JSON_VALUE)
					  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					  .body(body)
					  .asJson();
			
			JSONObject responseBody = jsonPosts.getBody().getObject();
			assertNotNull(jsonPosts.getBody());
			assertEquals(responseBody.get("content"), post.getContent());
			assertEquals(responseBody.get("username"), post.getUsername());
			assertEquals(jsonPosts.getStatus(),200);
			
		}catch (UnirestException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
	
		@Test
		public void test_comment_api(){
			
			HttpResponse<JsonNode> jsonPosts;
			
			ObjectMapper mapper = new ObjectMapper();
			User user = new User();
			user.setFirstName("Sarah");
			user.setLastName("Palin");
			user.setUsername("s.palin");
			
			Post post = new Post();
			post.setContent("Comment for post");
			post.setType("type post");
			post.setUsername("saloni");
			
			Comment comment = new Comment();
			comment.setText("this is comment for Comment_api");
			comment.setPostId(post.getId());
			
			
		try{
			JsonNode body = new JsonNode(mapper.writeValueAsString(comment));
			jsonPosts = Unirest.post("http://localhost:8080/blog/api/posts/"+post.getId()+"/comments")
					  .header("accept", MediaType.APPLICATION_JSON_VALUE)
					  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					  .body(body)
					  .asJson();
			
			JSONObject responseBody = jsonPosts.getBody().getObject();
			assertNotNull(jsonPosts.getBody());
			//assertEquals(responseBody.get("text"), comment.getText());
			
			//assertEquals(jsonPosts.getStatus(),200);
			
		}catch (UnirestException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
