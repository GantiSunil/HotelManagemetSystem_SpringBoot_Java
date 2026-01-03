package com.sunil.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String customerName;
	
	private String idProof;
	
	private String idProofNo;
	
	private String gender;
	
	private String mobileNo;
	
	private String email;
	
	private String address;
	
	private String countryId;
	
	private String stateId;
	
	private LocalDateTime creationDate;
	
	private int noOfVistts;
	
	
	

}
