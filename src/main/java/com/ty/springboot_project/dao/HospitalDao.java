package com.ty.springboot_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_project.dto.Hospital;
import com.ty.springboot_project.repo.HospitalRepo;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepo hospitalRepo;
	public Hospital saveHospital(Hospital hospital) {
		 return hospitalRepo.save(hospital);
	}

	public Hospital updateHospital(int id,Hospital hospital) {
		
		if(hospitalRepo.findById(id).isPresent()) {
			hospital.setId(id);
			
			return hospitalRepo.save(hospital);
		}
		return null;
	}
	public Hospital deleteHospital(int id) {
		
		if(hospitalRepo.findById(id).isPresent()) {
			Hospital hospital=hospitalRepo.findById(id).get();
			hospitalRepo.delete(hospital);
			return hospital;
		}
		return null;
	}
	public Hospital getById(int id) {
	
		if(hospitalRepo.findById(id).isPresent()) {
			Hospital hospital=hospitalRepo.findById(id).get();
			return hospital;
		}
		return null;
	}
	public Hospital getByEmail(String email) {
		return hospitalRepo.getByEmail(email);
	}
	public List<Hospital> getAllHospital() {
		return hospitalRepo.findAll();
	}
}
