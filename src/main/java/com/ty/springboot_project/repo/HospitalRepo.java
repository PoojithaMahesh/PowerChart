package com.ty.springboot_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_project.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

	public Hospital getByEmail(String email);
}
