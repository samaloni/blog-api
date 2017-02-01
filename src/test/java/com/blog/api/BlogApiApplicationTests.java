package com.blog.api;

import static org.testng.Assert.*;

import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import com.blog.api.domain.User;



public class BlogApiApplicationTests {

	@Test
	public void test_posts_users_api(){
		HttpResponse<JsonNode> jsonResponse;
		User user = new User();
		user.setFirstName("Shrey");
		user.setLastName("Panse");
		user.setUsername("spanse");
		
		try{
			jsonResponse = Unirest.post("http://localhost:8080/blog/api/users")
					.header("accept", ContentType.APPLICATION_JSON.getMimeType())
					.body(mapper.wrteValueAsString(user))
					.asJson();
			
			assertNotNull(jsonResponse);
		}catch(UnirestException e){
			e.printStackTrace();
		}catch(JsonProcessingException e){
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void contextLoads() {
		
	}

}
