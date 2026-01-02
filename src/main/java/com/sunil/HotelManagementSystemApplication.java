package com.sunil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sunil.controller.HMSMasterController;
import com.sunil.model.Rooms;
import com.sunil.repository.HMSRoomsRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Hotel Management API",version="1.0",description="Documentions For HMS"))
public class HotelManagementSystemApplication {
//implements CommandLineRunner{
	
	//@Autowired
	//private HMSRoomsRepository hmsRoomsRepository;

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementSystemApplication.class, args);
		
		//HMSMasterController ctrl=ac.getBean(HMSMasterController.class);
		//ctrl.test();
		System.out.println("=======Hotel Management=====================");
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * System.out.println("=====Commmand Line Runner============");
	 * 
	 * Rooms rooms=new Rooms(); rooms.setRoomNo("G105"); rooms.setRoomType("AC");
	 * rooms.setStatus("available");
	 * 
	 * hmsRoomsRepository.save(rooms);
	 * 
	 * System.out.print("****************************OBJECT SAVED"); }
	 */

	
}
