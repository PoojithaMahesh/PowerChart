package com.ty.springboot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.PersonDao;
import com.ty.springboot_project.dto.Person;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;
@Service
public class PersonService {
	@Autowired
	private PersonDao dao;


	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person){
		ResponseStructure<Person> responseStructure=new ResponseStructure<>();
		Person person2=dao.savePerson(person);
		
		responseStructure.setMessage("saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(person2);
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.CREATED);

	}
	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id,Person person){
		ResponseStructure<Person> responseStructure=new ResponseStructure<>();
		Person daoPerson=dao.updatePerson(id, person);
		if(daoPerson!=null) {
			responseStructure.setMessage("updated succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoPerson);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Person is not found for this id");
		}
	}
	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id){
		ResponseStructure<Person> responseStructure=new ResponseStructure<>();
		Person person=dao.deletePerson(id);
		if(person!=null) {
			responseStructure.setMessage("deleted succesfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Person is not found for this id");
		}
	}
	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id){
		ResponseStructure<Person> responseStructure=new ResponseStructure<>();
		Person person=dao.getById(id);
		if(person!=null) {
			responseStructure.setMessage("found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException("Person is not found for this id");
		}
		
	}
}
