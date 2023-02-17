package com.ty.springboot_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "medname not be null")
	@NotBlank(message = "medname not be Blank")
	private String medname;
	private double cost;
	
	@ManyToOne
	private MedOrder medOrder;

}

