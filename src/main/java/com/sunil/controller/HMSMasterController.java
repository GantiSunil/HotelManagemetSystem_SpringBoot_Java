package com.sunil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.model.RoomType;
import com.sunil.model.Rooms;
import com.sunil.model.UsersInfo;
import com.sunil.security.UserInfoServiceImp;
import com.sunil.service.HMSMasterIService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/master/")
@CrossOrigin("*")
@Slf4j

public class HMSMasterController {

	@Autowired
	private HMSMasterIService hmsMasterIService;
	
	
	@Autowired
	private UserInfoServiceImp userInfoServiceImp;
	

	@PostMapping("saveRooms")
	@Operation(
		    summary = "Create Room"
		    		)
    @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Rooms> saveRooms(@Valid @RequestBody Rooms rooms) {
	
			return ResponseEntity.ok(hmsMasterIService.saveRooms(rooms));
		
		

	}
	
	@GetMapping("getAllRooms")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Rooms>> getAllRooms()
	{
		return ResponseEntity.ok(hmsMasterIService.getAllRooms());
	}
	
	
	@GetMapping("test")
	public String test()
	{
		System.out.println("GET METHOD");
		return "Hi ,Welcome To HMS";
	}
	
	
	@PostMapping("saveRoomType")
	public ResponseEntity<RoomType> saveRoomType(@RequestBody RoomType roomType)
	{
		
		return ResponseEntity.ok(hmsMasterIService.saveRoomType(roomType));
		
	}
	
	
	//-------------  Creating Users  --------------
	
	@PostMapping("saveUsers")
	public ResponseEntity<?> saveUsers(@RequestBody UsersInfo usersInfo)
	{
		return  ResponseEntity.ok(hmsMasterIService.saveUsers(usersInfo));
	}
	
	
	@GetMapping("getAllUsers")
	public ResponseEntity<?> getAllUsers()
	{
		return ResponseEntity.ok(hmsMasterIService.getUsersInfo());
	}
	
	//------------ Login Api -----------
	@PostMapping("login")
	public ResponseEntity<?>  login(@RequestBody UsersInfo usersInfo) 
	{//getUserInfo
		
		return ResponseEntity.ok(userInfoServiceImp.getUserInfo(usersInfo));
	}

}
