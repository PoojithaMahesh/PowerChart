package com.ty.springboot_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.EncounterDao;
import com.ty.springboot_project.dao.MedOrderDao;
import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.dto.MedOrder;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class MedOrderService {
	
	@Autowired
	private MedOrderDao medOrderDao;
	
	@Autowired
	private EncounterDao encounterDao;
	
	
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int eid){
		
		Encounter encounter=encounterDao.getById(eid);
		if(encounter!=null) {
		medOrder.setEncounter(encounter);
		
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medOrderDao.saveMedOrder(medOrder));
		
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.CREATED);
		}else {
			throw new IdNotFoundException("MedOrder is not found for this id");
		}
	}
	
	

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder, int mid){
		MedOrder daoMedOrder= medOrderDao.getMedOrderById(mid);
		
		if(daoMedOrder!=null) {
			medOrder.setEncounter(daoMedOrder.getEncounter());
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully Updated");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(medOrderDao.updateMedOrder(medOrder, mid));
		
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("MedOrder is not found for this id");
		}
		
	}
	

	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int eid){
		MedOrder daoMedOrder= medOrderDao.deleteMedOrder(eid);
		if(daoMedOrder!=null) {
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("successfully deleted");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(daoMedOrder);
		
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("MedOrder is not found for this id");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int eid){
		MedOrder daoMedOrder= medOrderDao.getMedOrderById(eid);
		if(daoMedOrder!=null) {
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Found");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(medOrderDao.getMedOrderById(eid));
		
		return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException("MedOrder is not found for this id");
		}
		
	}
	
	

	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrderByEncounter(int eid){
		List<MedOrder> daoMedOrder =medOrderDao.getAllMedOrderByEncounter(eid);
		if(daoMedOrder!=null) {
			ResponseStructure<List<MedOrder>> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoMedOrder);
			return new ResponseEntity<ResponseStructure<List<MedOrder>>>(responseStructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException("MedOrder is not found for this id");
		}
		
	}}
	
