package com.ty.springboot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.AddressDao;
import com.ty.springboot_project.dto.Address;
import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address){
		Address address2=dao.saveAddress(address);
	    ResponseStructure<Address> responseStructure=new ResponseStructure<>();
	    responseStructure.setMessage("address added successfully");
	    responseStructure.setStatus(HttpStatus.CREATED.value());
	    responseStructure.setData(address2);
	    return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id,Address address){
	    Address address2=dao.updateAddress(id, address);
		ResponseStructure<Address> responseStructure=new ResponseStructure<>();
		if(address2!=null) {
			responseStructure.setMessage("updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address2);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Address is not found for this id");
		}
		
	}
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id){
		ResponseStructure<Address> responseStructure=new ResponseStructure<>();
		Address address=dao.deleteById(id);
		if(address!=null) {
			responseStructure.setMessage("deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Address is not found for this id");
		}
	}
		public ResponseEntity<ResponseStructure<Address>> getAddress(int id){
			ResponseStructure<Address> responseStructure=new ResponseStructure<>();
		    Address address=dao.getById(id);
			if(address!=null) {
				responseStructure.setMessage("found successfully");
				responseStructure.setStatus(HttpStatus.FOUND.value());
				responseStructure.setData(address);
				return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
			}else {
				throw new IdNotFoundException("Address is not found for this id");
			}
		}
		
	
	
	
	
	
	
	
}
