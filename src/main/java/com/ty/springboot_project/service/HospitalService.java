package com.ty.springboot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.HospitalDao;
import com.ty.springboot_project.dto.Hospital;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<>();
		Hospital hospital2=dao.saveHospital(hospital);
		
		responseStructure.setMessage("saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(hospital2);
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);

	}
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id,Hospital hospital){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<>();
		Hospital daoHospital=dao.updateHospital(id, hospital);
		if(daoHospital!=null) {
			responseStructure.setMessage("updated succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Hospital is not found for this id");
		}
	}
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<>();
		Hospital hospital=dao.deleteHospital(id);
		if(hospital!=null) {
			responseStructure.setMessage("deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Hospital is not found for this id");
		}
	}
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<>();
		Hospital hospital=dao.getById(id);
		if(hospital!=null) {
			responseStructure.setMessage("found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException("Hospital is not found for this id");
		}
		
	}
}
