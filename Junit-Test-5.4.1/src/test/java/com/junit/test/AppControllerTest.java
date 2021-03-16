package com.junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AppController.class)
class AppControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	void testWelcomeAPI() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/welcome");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("Controller Layer Testing", result.getResponse().getContentAsString());
	}
	
	@Test
	void testHelloAPI() throws Exception {
		mvc.perform( get( "/home?val=suvro") )
		.andExpect( content().string("Hello suvro"));
	}
	
	
	

}
