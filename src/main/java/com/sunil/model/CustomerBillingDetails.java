package com.sunil.model;

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
public class CustomerBillingDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerBillingId;
	
	private String roomId;
	
	private String roomNo;
	
	private int billingsDays;
	
	private String customerId;
	
	private double actualPrice;
	
	private double finalPrice;
	
	private double discount;
	

}
