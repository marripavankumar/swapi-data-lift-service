package com.swapi.data.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class StarWarsApiControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void swapiControllerwith200OK() throws Exception {
		 MvcResult mvcResult = mockMvc.perform(get("/swapi/filmdetails?type=planets&name=Tatooine")
				  .content("{\r\n" + 
				  		"    \"count\": 60,\r\n" + 
				  		"    \"next\": \"https://swapi.dev/api/planets/?page=2\",\r\n" + 
				  		"    \"previous\": null,\r\n" + 
				  		"    \"results\": [\r\n" + 
				  		"        {\r\n" + 
				  		"            \"name\": \"Tatooine\",\r\n" + 
				  		"            \"diameter\": \"10465\",\r\n" + 
				  		"            \"rotation_period\": \"23\",\r\n" + 
				  		"            \"orbital_period\": \"304\",\r\n" + 
				  		"            \"gravity\": \"1 standard\",\r\n" + 
				  		"            \"population\": \"200000\",\r\n" + 
				  		"            \"climate\": \"arid\",\r\n" + 
				  		"            \"terrain\": \"desert\",\r\n" + 
				  		"            \"surface_water\": \"1\",\r\n" + 
				  		"            \"residents\": [\r\n" + 
				  		"                \"https://swapi.dev/api/people/1/\",\r\n" + 
				  		"                \"https://swapi.dev/api/people/2/\",\r\n" + 
				  		"                \"https://swapi.dev/api/people/4/\",\r\n" + 
				  		"                \"https://swapi.dev/api/people/6/\",\r\n" + 
				  		"                \"https://swapi.dev/api/people/7/\",\r\n" + 
				  		"                \"https://swapi.dev/api/people/8/\",\r\n" + 
				  		"                \"https://swapi.dev/api/people/9/\",\r\n" + 
				  		"                \"https://swapi.dev/api/people/11/\",\r\n" + 
				  		"                \"https://swapi.dev/api/people/43/\",\r\n" + 
				  		"                \"https://swapi.dev/api/people/62/\"\r\n" + 
				  		"            ],\r\n" + 
				  		"            \"films\": [\r\n" + 
				  		"                \"https://swapi.dev/api/films/1/\",\r\n" + 
				  		"                \"https://swapi.dev/api/films/3/\",\r\n" + 
				  		"                \"https://swapi.dev/api/films/4/\",\r\n" + 
				  		"                \"https://swapi.dev/api/films/5/\",\r\n" + 
				  		"                \"https://swapi.dev/api/films/6/\"\r\n" + 
				  		"            ],\r\n" + 
				  		"            \"url\": \"https://swapi.dev/api/planets/1/\",\r\n" + 
				  		"            \"created\": \"2014-12-09T13:50:49.641000Z\",\r\n" + 
				  		"            \"edited\": \"2014-12-20T20:58:18.411000Z\"\r\n" + 
				  		"        }\r\n" + 
				  		"    ]\r\n" + 
				  		"}")
	    	      .contentType(MediaType.APPLICATION_JSON)
	    	      .accept(MediaType.APPLICATION_JSON)
	    	      ).andReturn();
		 
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);  	  
	}

	@Test
	void swapiControllerwith500_InternalServerError() throws Exception {
		 MvcResult mvcResult = mockMvc.perform(get("/swapi/filmdetails?type=planets&name=Mirial2")
				  .content("{\r\n" + 
				  		"    \"status\": \"INTERNAL_SERVER_ERROR\",\r\n" + 
				  		"    \"message\": null,\r\n" + 
				  		"    \"errors\": [\r\n" + 
				  		"        \"DataNotFound {message:Data Not Found, created_time:2022-06-12T18:37:49.078}(OR)TypeNotFound {message:Requested Url Type is not found., created_time:2022-06-12T18:37:49.079}\"\r\n" + 
				  		"    ]\r\n" + 
				  		"}")
	    	      .contentType(MediaType.APPLICATION_JSON)
	    	      .accept(MediaType.APPLICATION_JSON)
	    	      ).andReturn();
		 
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(500, status);  	  
	}
	
	@Test
	void swapiControllerwith404_DataNotFoound() throws Exception {
		 MvcResult mvcResult = mockMvc.perform(get("/swapi1/filmdetails?type=planets&name=Mirial2")
				  .content("{\r\n" + 
				  		"    \"timestamp\": 1655039512834,\r\n" + 
				  		"    \"status\": 404,\r\n" + 
				  		"    \"error\": \"Not Found\",\r\n" + 
				  		"    \"message\": \"\",\r\n" + 
				  		"    \"path\": \"/swapi1/filmdetails\"\r\n" + 
				  		"}")
	    	      .contentType(MediaType.APPLICATION_JSON)
	    	      .accept(MediaType.APPLICATION_JSON)
	    	      ).andReturn();
		 
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(404, status);  	  
	}
}
