package com.ty.springboot_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_project.dto.Hospital;
import com.ty.springboot_project.dto.Person;
import com.ty.springboot_project.repo.PersonRepo;

@Repository
public class PersonDao {
	@Autowired
	private PersonRepo repo;
	public Person savePerson(Person person) {
		 return repo.save(person);
	}

	public Person updatePerson(int id,Person person) {
		
		if(repo.findById(id).isPresent()) {
			person.setId(id);
			
			return repo.save(person);
		}
		return null;
	}
	public Person deletePerson(int id) {
		
		if(repo.findById(id).isPresent()) {
			Person person=repo.findById(id).get();
			repo.delete(person);
			return person;
		}
		return null;
	}
	public Person getById(int id) {
	
		if(repo.findById(id).isPresent()) {
			Person person=repo.findById(id).get();
			return person;
		}
		return null;
	}


}
