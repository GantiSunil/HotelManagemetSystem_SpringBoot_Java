package com.sunil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
public class ServiceTypes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer serviceTypeId;
	
	private String serviceTypes;
	
	private String status;

}
