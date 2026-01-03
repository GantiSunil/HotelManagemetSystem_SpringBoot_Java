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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerBillingSummmary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String billNo;
	
	private String invioceno;
	
	private String customerId;
	
	private double actualPrice;
	
	private double finalPrice;
	
	private double discount;
	
	private double gstAmount;
	
	private int gstId;
	
	

}
