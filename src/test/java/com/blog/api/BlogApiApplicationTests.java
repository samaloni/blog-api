package com.blog.api;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;


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
		
		//List<User> users = new ArrayList<>();
		//users.add(user);
		
		try {
			JsonNode body = new JsonNode(mapper.writeValueAsString(user));
			jsonResponse = Unirest.post("http://localhost:8080/blog/api/users")
					  .header("accept", MediaType.APPLICATION_JSON_VALUE)
					  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					  .body(body)
					  .asJson();
			JSONObject responseBody = jsonResponse.getBody().getObject();
			
			//User new_user = (User) responseBody.get("user");		// response body is the userLis, take user from the userList
			assertNotNull(jsonResponse.getBody());
			assertEquals(responseBody.getString("firstName"), user.getFirstName());		//add user test case 
			
			assertEquals(responseBody.getString("lastName"), user.getLastName());
			assertEquals(responseBody.getString("username"), user.getUsername());
			assertEquals(jsonResponse.getStatus(),200);
			
			//assertEquals((User) responseBody.get("user"), users.get(0));
			
			//assertEquals(new_user.getFirstName(), user.getFirstName());
			
			
			// add test cases for get post put  delete and null username
			
		} catch (UnirestException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test_post_usersList() {
		HttpResponse<JsonNode> jsonResponse;
		
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user.setFirstName("Sarah");
		user.setLastName("Palin");
		user.setUsername("s.palin");
		
		User user1 = new User();
		user1.setFirstName("Sam");
		user1.setLastName("Panse");
		user1.setUsername("s.panse");
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user1);
		
		try {
			
			JsonNode body = new JsonNode(mapper.writeValueAsString(user));
			jsonResponse = Unirest.post("http://localhost:8080/blog/api/users")
					  .header("accept", MediaType.APPLICATION_JSON_VALUE)
					  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					  .body(body)
					  .asJson();
			JSONObject responseBody = jsonResponse.getBody().getObject();
			

			JsonNode body1 = new JsonNode(mapper.writeValueAsString(user1));
			jsonResponse = Unirest.post("http://localhost:8080/blog/api/users")
					  .header("accept", MediaType.APPLICATION_JSON_VALUE)
					  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					  .body(body1)
					  .asJson();
			JSONObject responseBody1 = jsonResponse.getBody().getObject();
			
			assertEquals(responseBody.get("firstName"), user.getFirstName());
			assertEquals(responseBody1.get("firstName"), user1.getFirstName());
			
			//assertEquals(responseBody.get("user"),user);
			
			
		
		} catch (UnirestException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void test_user_getAllUsers() {
		HttpResponse<JsonNode> jsonResponse;
		
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user.setFirstName("Sarah");
		user.setLastName("Palin");
		user.setUsername("s.palin");
		
		User user1 = new User();
		user1.setFirstName("Sam");
		user1.setLastName("Panse");
		user1.setUsername("s.panse");
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user1);
		
		try {
			
			JsonNode body = new JsonNode(mapper.writeValueAsString(user));
			jsonResponse = Unirest.post("http://localhost:8080/blog/api/users")
					  .header("accept", MediaType.APPLICATION_JSON_VALUE)
					  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					  .body(body)
					  .asJson();
			JSONObject responseBody = jsonResponse.getBody().getObject();
			

			JsonNode body1 = new JsonNode(mapper.writeValueAsString(user1));
			jsonResponse = Unirest.post("http://localhost:8080/blog/api/users")
					  .header("accept", MediaType.APPLICATION_JSON_VALUE)
					  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					  .body(body1)
					  .asJson();
			JSONObject responseBody1 = jsonResponse.getBody().getObject();
			
			HttpResponse<User[]> user_resp = Unirest.get("http://localhost:8080/blog/api/users")
					.asObject(User[].class);
			
			User[] userArray = user_resp.getBody(); //array of users
					
			assertEquals(responseBody.get("firstName"), userArray[0]);
			assertEquals(responseBody1.get("firstName"), userArray[1]);
			
			//assertEquals(responseBody.get("user"),user);
			
			
		
		} catch (UnirestException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}

	
	
	@Test
	public void test_update_user(){
		HttpResponse<JsonNode> jsonResponse;
		
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user.setFirstName("Sarah");
		user.setLastName("Palin");
		user.setUsername("s.palin");
		
		try{
			JsonNode body = new JsonNode(mapper.writeValueAsString(user));
			jsonResponse = Unirest.post("http://localhost:8080/blog/api/users")
					  .header("accept", MediaType.APPLICATION_JSON_VALUE)
					  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					  .body(body)
					  .asJson();
			//JSONObject responseBody = jsonResponse.getBody().getObject();
			
			
			user.setFirstName("sampada");
			
			
			JsonNode body1 = new JsonNode(mapper.writeValueAsString(user));
			jsonResponse = Unirest.put("http://localhost:8080/blog/api/"+user.getId()+"/users")
					  .header("accept", MediaType.APPLICATION_JSON_VALUE)
					  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
					  .body(body1)
					  .asJson();
			JSONObject responseBody1 = jsonResponse.getBody().getObject();
						
			
			assertEquals(String.valueOf(responseBody1.get("firstName")),"sampada");
			
			
			
		}catch (UnirestException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}		
	}
	
	
		@Test
		public void test_posts(){
			
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
			
			 List<Comment> commentList= new ArrayList<Comment>();
             
		    Comment comment = new Comment();
		    comment.setText("this is comment for Comment_api");
		    comment.setPostId(post.getId());
		        
		    commentList.add(comment);
		    post.setComments(commentList);
			
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
	        
	        List<Comment> commentList= new ArrayList<Comment>();
	                    
	        Comment comment = new Comment();
	        comment.setText("this is comment for Comment_api");
	        comment.setPostId(post.getId());
	        
	        commentList.add(comment);
	        post.setComments(commentList);
	        
	        
	    try{
	        JsonNode body = new JsonNode(mapper.writeValueAsString(comment));
	        jsonPosts = Unirest.post("http://localhost:8080/blog/api/posts/"+post.getId()+"/comments")
	                  .header("accept", MediaType.APPLICATION_JSON_VALUE)
	                  .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
	                  .body(body)
	                  .asJson();
	        
	        JSONObject responseBody = jsonPosts.getBody().getObject();
	        assertNotNull(responseBody);
	        //assertEquals(responseBody.get("text"), comment.getText());
	        
	        //assertEquals(jsonPosts.getStatus(),400);
	        
	       // assertEquals(responseBody.getString("text"), comment.getText());
	        
	       // System.out.println("This is respponse body : "+responseBody.toString());
	        
	    }catch (UnirestException e) {
	        e.printStackTrace();
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
   }	
	
		
		
		
		
			

}
