/*package com.blog.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

 
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.blog.api.domain.User;
import com.blog.api.service.UserService;

public class TestClass {
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private UserService userService;
	
	
	
	@Test
	public void findAllUser() throws Exception{
		
		User user2 = new User();
		
		user2.setFirstName("Atul");
		user2.setLastName("Nipane");
		user2.setUsername("atulnipane");
		
		User user1 = new User();
		
		user1.setFirstName("Sampada");
		user1.setLastName("Panse");
		user1.setUsername("saloni");
		
		userService.save(user2);
		userService.save(user1);
		
		when(userService.list()).thenReturn(Arrays.asList(user2, user1));
		
		
		mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        //.andExpect(content().contentType(TestNGUtils.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].id", is(1L)))
        .andExpect(jsonPath("$[0].firstName", is("Atul")))
        .andExpect(jsonPath("$[0].lastName", is("Nipane")))
        .andExpect(jsonPath("$[0].userName", is("atulnipane")))
        .andExpect(jsonPath("$[0].id", is(2L)))
        .andExpect(jsonPath("$[0].firstName", is("Sampada")))
        .andExpect(jsonPath("$[0].lastName", is("Panse")))
        .andExpect(jsonPath("$[0].userName", is("saloni")));

		verify(userService, times(1)).list();
		verifyNoMoreInteractions(userService);
		
		
	}
	

}*/