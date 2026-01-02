package com.sunil.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sunil.model.RoomType;
import com.sunil.model.Rooms;
import com.sunil.model.UsersInfo;

@Service
public interface HMSMasterIService {
	
	public List<Rooms> saveAllRooms(List<Rooms> rooms) throws Exception; 
	
	public Rooms saveRooms(Rooms rooms) ; 
	
	public RoomType saveRoomType(RoomType roomType);
	
	public List<Rooms> getAllRooms();
	
	public UsersInfo saveUsers(UsersInfo usersInfo);
    
	public List<UsersInfo> getUsersInfo();

}
