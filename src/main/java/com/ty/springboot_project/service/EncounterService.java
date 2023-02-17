package com.ty.springboot_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.BranchDao;
import com.ty.springboot_project.dao.EncounterDao;
import com.ty.springboot_project.dao.PersonDao;
import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.dto.Person;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class EncounterService {
@Autowired
private EncounterDao dao;
@Autowired 
private BranchDao branchDao;
@Autowired
private PersonDao personDao;
public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(int personid,int branchid,Encounter encounter){
	ResponseStructure<Encounter> structure=new ResponseStructure<>();
	Person person=personDao.getById(personid);
	Branch branch=branchDao.getBranchById(branchid);
	encounter.setPerson(person);
	List<Branch> list=new ArrayList<>();
	list.add(branch);
	encounter.setBranchs(list);
	structure.setMessage("saved encounter");
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setData(dao.saveEncounter(encounter));
	return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.CREATED);
	
}
public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int eid, int branchid) {
	ResponseStructure<Encounter> structure=new ResponseStructure<>();
	Encounter encounter2=dao.getById(eid);
	Branch branch=branchDao.getBranchById(branchid);
	List<Branch> list=encounter2.getBranchs();
	list.add(branch);
	
	encounter.setBranchs(list);
	encounter.setPerson(encounter2.getPerson());
	Encounter encounter3=dao.updateEncounter(eid,encounter);
	if(encounter3!=null) {
	structure.setMessage("updated successfully");
	structure.setStatus(HttpStatus.OK.value());
	structure.setData(encounter3);
	return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.OK);
	}else {
		throw new IdNotFoundException("Encounter is not found for this id");
	}
}
public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
	ResponseStructure<Encounter> structure=new ResponseStructure<>();
	Encounter encounter=dao.deleteById(id);
	if(encounter!=null) {
		structure.setMessage("deletd successfully");	
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(encounter);
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.OK);
	}else {
		throw new IdNotFoundException("Encounter is not found for this id");
	}
		

}
public ResponseEntity<ResponseStructure<Encounter>> getEncounter(int id) {
	ResponseStructure<Encounter> structure=new ResponseStructure<>();
	Encounter encounter=dao.getById(id);
	if(encounter!=null) {
		structure.setMessage("deletedSuccesfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(encounter);
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.OK);
	}else {
		throw new IdNotFoundException("Encounter is not found for this id");
	}
}
}
