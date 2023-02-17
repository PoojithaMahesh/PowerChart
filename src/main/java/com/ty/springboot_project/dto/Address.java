package com.ty.springboot_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@NotNull(message = "area is mandatory")
	@NotBlank(message = "area should not be blank")
private String area;
private int pincode;
@NotNull(message = "city is mandatory")
@NotBlank(message = "city should not be blank")
private String city;
@NotNull(message = "state is mandatory")
@NotBlank(message = "state should not be blank")
private String state;

}
