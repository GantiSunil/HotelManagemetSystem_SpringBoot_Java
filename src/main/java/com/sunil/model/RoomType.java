package com.sunil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RoomType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roomTypeId;
	@Column(nullable=false)
	private String roomType;
	@Column(nullable=false)
	private double offerPrice;
	@Column(nullable=false)
	private int capacity;
	private String description;
	@Column(nullable=false)
	private double fixedPrice;
	@Column(nullable=false)
	private double actualPrice;


}
