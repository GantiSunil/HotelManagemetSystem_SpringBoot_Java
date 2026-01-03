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
public class Regrevation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer regrevationId;
	
	private String customerId;
	
	private String roomNo;
	
	private String roomId;
	
	private int noOfDays;
	
	private LocalDateTime bookingTime;
	
	private LocalDateTime checkInTime;
	
	private LocalDateTime checkOutTime;

}
