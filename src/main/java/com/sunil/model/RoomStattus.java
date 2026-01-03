package com.sunil.model;

import jakarta.persistence.Column;
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
@AllArgsConstructor
@ToString
@Entity
public class RoomStattus {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer statusId;
	
	@Column(nullable=false)
	private String statusType;
	
	
	@Column(nullable=false)
	private String status;

}
