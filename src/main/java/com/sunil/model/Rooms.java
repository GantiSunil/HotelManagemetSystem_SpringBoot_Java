package com.sunil.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Hotel Rooms")
public class Rooms {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roomId;
	
	@Schema(description = "roomType", defaultValue = "AC")
	@Column(nullable=false)
	@NotNull(message="RoomType value is null")
	private String roomType;
	@Schema(description = "roomNo", defaultValue = "G1111")
	@Column(unique=true)
	private String roomNo;
	@Schema(description = "status", defaultValue = "available")
	@Column(nullable=false)
	private String status;
	
	

	

}
