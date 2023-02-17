package com.ty.springboot_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@NotNull(message = "name is mandatory")
	@NotBlank(message = "name should not be blank")
private String name;
private long phone;
@NotNull(message = "Manager is mandatory")
@NotBlank(message = "Manager should not be blank")
private String manager;
@ManyToOne
private Hospital hospital;
@OneToOne
private Address address;



}
