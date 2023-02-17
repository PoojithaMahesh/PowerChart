package com.ty.springboot_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ty.springboot_project.dto.Address;
import com.ty.springboot_project.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepo repo;
	public Address saveAddress(Address address) {
		return repo.save(address);
	}
    public Address updateAddress(int id,Address address) {
    	Address address2=repo.findById(id).get();
    	if(address2!=null) {
    		address.setId(id);
    		return repo.save(address);
    		
    	}
    	return null;
    }
    public Address getById(int id) {
    	
    	if(repo.findById(id).isPresent()) {
    		Address address=repo.findById(id).get();
    		return address;
    	}
    	return null;
    }
    public Address deleteById(int id) {
    	if(repo.findById(id).isPresent()) {
    		Address address=repo.findById(id).get();
    		repo.delete(address);
    		return address;
    		
    	}
    	return null;
    }
}
