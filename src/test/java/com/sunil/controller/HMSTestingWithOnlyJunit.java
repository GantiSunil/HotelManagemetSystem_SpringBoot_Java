package com.sunil.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunil.model.Rooms;

@SpringBootTest
@AutoConfigureMockMvc
public class HMSTestingWithOnlyJunit
{
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Disabled
	public void getRoomsTestingWithOnlyJunit() throws Exception
    {
		
		/*
		 *  mockMvc.perform(get("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(75000));
		 */
		mockMvc.perform(get("/api/master/getAllRooms")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].roomId").value(2));
	}
	
	
	@Test
	@Disabled
	public void saveRoomsTestingOnlyWithJunit() throws Exception
	{
		// .content(objectMapper.writeValueAsString(product)))
		Rooms rooms = new Rooms(null,"AC","D119","avaliable");
		
		mockMvc.perform(post("/api/master/saveRooms")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(rooms)))
		.andExpect(status().isOk());
		
		
		
 		
	}
	
	
	

}
