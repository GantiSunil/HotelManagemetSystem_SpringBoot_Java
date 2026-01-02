package com.sunil.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunil.model.Rooms;
import com.sunil.service.HMSMasterIService;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;

@WebMvcTest(HMSMasterController.class)
public class HMSMasterControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	 @MockBean
	private HMSMasterIService hMSMasterIService;
	
	
	
	@Test
	@Disabled
	public void master() throws Exception 
	{
		
		Rooms rooms = new Rooms(); 
		
		rooms.setRoomNo("206");
		rooms.setRoomType("AC");
		rooms.setStatus("1");
		
		//  Mockito.when(service.getEmployeeById(1)).thenReturn(emp);
		//Mockito.when(hMSMasterIService.saveRooms(rooms)).thenReturn(rooms);
		
		/*
		 *   mockMvc.perform(MockMvcRequestBuilders.get("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"));
		 */
		
		//mockmvc.perform(MockMvcRequestBuilders.post("/api/master/saveRooms"))
		//.andExpect(status().isOk())
		//.andExpect(jsonPath("$.RoomNo").value("202"));
		
		  Mockito.when(hMSMasterIService.saveRooms(Mockito.any(Rooms.class)))
          .thenReturn(rooms);
		  
		  

		  mockmvc.perform(
          MockMvcRequestBuilders.post("/api/master/saveRooms")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(new ObjectMapper().writeValueAsString(rooms))
  )
  .andExpect(status().isOk())
  .andExpect(jsonPath("$.roomNo").value("206"))
  .andExpect(jsonPath("$.roomType").value("AC"));
		
		
	}
	
	
	@Test
	@Disabled
	public void testingGetAllRooms() throws Exception 
	{
		List<Rooms> roomsList = new ArrayList<>();
		
		
		/*l
		 * {
        "roomId": 1,
        "roomType": "AC",
        "roomNo": "G101",
        "status": "available"
    },
    {
        "roomId": 2,
        "roomType": "AC",
        "roomNo": "G102",
        "status": "available"
    }
		 */
		roomsList.add(new Rooms(1,"AC","G101","available"));
		roomsList.add(new Rooms(2,"AC","G102","available"));
		
		
		
		Mockito.when(hMSMasterIService.getAllRooms()).thenReturn(roomsList);
		
		
		
		/*
		 *         mockMvc.perform(get("/api/products/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(75000));
		 */
		mockmvc.perform(get("/api/master/getAllRooms")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].roomId").value(1))
				.andExpect(jsonPath("$[0].roomType").value("AC"))
				.andExpect(jsonPath("$[0].roomNo").value("G101"))
				.andExpect(jsonPath("$[0].status").value("available"));
				
		
		
		
		
	}
	
	
	

}
