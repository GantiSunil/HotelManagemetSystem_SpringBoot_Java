package com.sunil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsersInfo {
	
	
	//private Integer id;
	@Id
	private String userName;
	
	private String roles;
	
	private String password;


	
	
	
	
	
	

}
