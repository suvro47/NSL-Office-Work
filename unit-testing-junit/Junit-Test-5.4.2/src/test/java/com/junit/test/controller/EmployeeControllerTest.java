package com.junit.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junit.test.model.Employee;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext applicationContext;
	
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	ObjectMapper mapper = new ObjectMapper();

	@Test
	void testAddEmployeeAPI() throws Exception {
		String name = "suvro";
		Employee employee = new Employee(name);

		String jsonRequest = mapper.writeValueAsString(employee);
		MvcResult result = mockMvc.perform( post("/addEmployee").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE)).andExpect( status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        
        Employee responseEmployee = mapper.readValue(resultContent, Employee.class);
        assertEquals(responseEmployee, employee );
	}
	
	
	

}
