package com.sunil.model;



import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ServicesBilling {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer serviceBillingId;
	
	private int serviceId;
	
	private String roomNO;
	
	private LocalDate entryDate;
	
	private LocalTime time;
	
	private LocalTime totalHours;
	
	private double actualPrice;
	
	private double discount;
	
	private double finalPrice;
	
	
}
