package com.sunil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Service {
	
@Id
private Integer id;
@Column(nullable=false)
private String serviceTypeId;
@Column(nullable=false)
private double price;
@Column(nullable=false)
private boolean status;





}
