package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.controllers.AvailabilityRestCotroller;

@SpringBootTest
@AutoConfigureMockMvc
class AvailabilityRestControllerTest {
	
	@Autowired
	AvailabilityRestCotroller availabilityRestController;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		assertThat(availabilityRestController).isNotNull();
	}
	
	@Test
	public void shouldReturnAllBranchesSuccessfully() throws Exception {
		String expected  = "{\"branches\":[{\"name\":\"Covid Vaccine Center\",\"location\":\"Sec- 19,Gurgaon\"},{\"name\":\"Covid Vaccine Center\",\"location\":\"Munirka,New Delhi\"},{\"name\":\"Covid Vaccine Center\",\"location\":\"Sec-62 ,Noida\"}]}";
		MvcResult result = mockMvc
	            .perform(
	                    get("/vaccine-now/branches")
	            .accept(
	                    MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk()).andReturn();
	String actual = result.getResponse().getContentAsString();
	assertNotNull(actual);
	assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnAvailableVaccinesWithBranchSuccessfully() throws Exception {
		
		String expected  = "{\"vaccineAvailability\":[{\"branch\":\"Covid Vaccine Center,Sec- 19,Gurgaon\",\"availibilityInBranch\":2400},{\"branch\":\"Covid Vaccine Center,Munirka,New Delhi\",\"availibilityInBranch\":5400},{\"branch\":\"Covid Vaccine Center,Sec-62 ,Noida\",\"availibilityInBranch\":10000}]}";
		MvcResult result = mockMvc
	            .perform(
	                    get("/vaccine-now/branch/vaccines")
	            .accept(
	                    MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk()).andReturn();
	String actual = result.getResponse().getContentAsString();
	System.out.println(actual);
	assertNotNull(actual);
	assertEquals(expected, actual);
	}
	
	

	@Test
	public void shouldReturnAvailableVaccinesForGivenBranchSuccessfully() throws Exception {
		
		String expected  = "{\"vaccineAvailability\":[{\"branch\":\"Covid Vaccine Center,Sec- 19,Gurgaon\",\"availibilityInBranch\":2400}]}";
		MvcResult result = mockMvc
	            .perform(
	                    get("/vaccine-now/branch/"+1+"/vaccines")
	            .accept(
	                    MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk()).andReturn();
	String actual = result.getResponse().getContentAsString();
	System.out.println(actual);
	assertNotNull(actual);
	assertEquals(expected, actual);
	}
	

}
