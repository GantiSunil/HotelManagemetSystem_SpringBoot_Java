package com.sunil.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunil.exception.HMSExceptionHandler;
import com.sunil.model.RoomType;
import com.sunil.model.Rooms;
import com.sunil.model.UsersInfo;
import com.sunil.repository.HMSMasterUserInfo;
import com.sunil.repository.HMSRoomTypeRepository;
import com.sunil.repository.HMSRoomsRepository;
import com.sunil.service.HMSMasterIService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HMSMasterServiceImpl implements HMSMasterIService
{
	
	@Autowired
	private  HMSRoomsRepository hmsRoomsRepository;
	
	@Autowired
	private HMSRoomTypeRepository hmsRoomTypeRepository;
	
	
	@Autowired
	private HMSMasterUserInfo  hmsMasterUserInfo;
	
	@Autowired
	private PasswordEncoder passwordencoder;

	@Override
	public Rooms saveRooms(Rooms rooms)  {
	
		return hmsRoomsRepository.save(rooms);
	}

	@Override
	public RoomType saveRoomType(RoomType roomType) {
		return hmsRoomTypeRepository.save(roomType);
	}
	
	public List<Rooms> getAllRooms()
	{
//		if(true)
//		throw new HMSExceptionHandler("Resource Not Found");
		
		return hmsRoomsRepository.findAll();
	}

	@Override
	public List<Rooms> saveAllRooms(List<Rooms> rooms) throws Exception {
		
		return hmsRoomsRepository.saveAll(rooms);
	}

	@Override
	public UsersInfo saveUsers(UsersInfo usersInfo) {
		
		//passwordencoder
		usersInfo.setPassword(passwordencoder.encode(usersInfo.getPassword()));
		
		return hmsMasterUserInfo.save(usersInfo);
	}

	@Override
	public List<UsersInfo> getUsersInfo() {
		// TODO Auto-generated method stub
		return hmsMasterUserInfo.findAll();
	}

	
	

}
