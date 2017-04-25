package com.blog.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.blog.api.controller.UserController;
import com.blog.api.service.UserService;


@SpringBootTest(classes = BlogApiApplication.class)
@WebAppConfiguration
public class UserControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	private MockMvc mockMvc;
	private UserService userService;
	private UserController userController;
	
	@Test
	public void userFinder() throws Exception{
		
		
		((ResultActions) ((MockHttpServletRequestBuilder) mockMvc.perform(get("/users"))
        .andExpect(status().isOk()))
        .contentType(contentType))
        .andExpect(status().isCreated())
       //.andExpect(contentType.compareTo(MediaType.APPLICATION_JSON));
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
	
	
	
	
	
}
