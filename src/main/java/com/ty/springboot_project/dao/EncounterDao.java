package com.ty.springboot_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.repo.EncounterRepo;

@Repository
public class EncounterDao {
@Autowired
private EncounterRepo repo;
public Encounter saveEncounter(Encounter encounter) {
	return repo.save(encounter);
}
public Encounter getById(int eid) {
     if(repo.findById(eid).isPresent()) {
    	 Encounter encounter=repo.findById(eid).get();
    	 return encounter;
     }
	return null;
}
public Encounter updateEncounter(int eid, Encounter encounter) {
	if(repo.findById(eid).isPresent()) {
		encounter.setId(eid);
		Encounter encounter2=repo.save(encounter);
		return encounter2;
	}
	return null;
}
public Encounter deleteById(int id) {
	if(repo.findById(id).isPresent()) {
		Encounter encounter=repo.findById(id).get();
		repo.delete(encounter);
		return encounter;
	}
	return null;
}
}
