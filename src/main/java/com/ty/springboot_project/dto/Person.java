package com.ty.springboot_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name is mandatory")
	@NotBlank(message = "name should not be blank")
	private String name;
	@NotNull(message = "email is mandatory")
	@NotBlank(message = "email should not be blank")
	private String email;
	private long phone;

}
