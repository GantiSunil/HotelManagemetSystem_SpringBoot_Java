package com.sunil.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.sunil.model.Rooms;
import com.sunil.repository.HMSRoomsRepository;
import com.sunil.serviceimpl.HMSMasterServiceImpl;

@ExtendWith(MockitoExtension.class)
public class HmsMasterServiceTesting {
	
	
	@Mock
	private HMSRoomsRepository  hMSRoomsRepository;
	
	@InjectMocks
	private HMSMasterServiceImpl hMSMasterServiceImpl;
	
	
	@Test
	@Disabled
	public void serviceGetRoomsTesting() 
	{
		
		List<Rooms> room = new ArrayList<Rooms>();
		
		room.add(new Rooms(1,"AC","D101","avaliable"));
		
		  /* when(userRepository.findById(1L))
           .thenReturn(Optional.of(user)); */
		
		when(hMSRoomsRepository.findAll()).thenReturn(room);
		
		
		List<Rooms> rooms = hMSMasterServiceImpl.getAllRooms();
		
		assertEquals(1,rooms.size());
		
		//assert
		
	}
	
	
	@Test
	@Disabled
	public void serviceLayerTestingforSave() throws Exception {
		
		List<Rooms> rooms = new ArrayList<>();
		
		rooms.add(new Rooms(1,"AC","D101","avaliable"));
		rooms.add(new Rooms(1,"AC","D101","avaliable"));
		
		hMSMasterServiceImpl.saveAllRooms(rooms);
		
		verify(hMSRoomsRepository,times(1)).saveAll(rooms);
		
		
	}
	
	@Test
	@Disabled
	public void serviceLayerTestingforGet() throws Exception {
		
		Rooms rooms = new Rooms(1,"AC","D101","avaliable");
		
		
		//hMSMasterServiceImpl.saveRooms(rooms);
		
		hMSMasterServiceImpl.getAllRooms();
		
		verify(hMSRoomsRepository,times(1)).findAll();
		
		
	}
	

}
