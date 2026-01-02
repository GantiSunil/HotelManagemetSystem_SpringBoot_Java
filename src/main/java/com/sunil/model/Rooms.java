package com.sunil.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity 
@Data
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
	
	

	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rooms(Integer roomId, String roomType, String roomNo, String status) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomNo = roomNo;
		this.status = status;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



}
