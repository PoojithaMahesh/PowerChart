package com.ty.springboot_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_project.dao.BranchDao;
import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.exception.IdNotFoundException;
import com.ty.springboot_project.repo.BarnchRepo;
import com.ty.springboot_project.util.ResponseStructure;

@Service
public class BranchService {

@Autowired
private BranchDao branchDao;
public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hid,int aid,Branch branch){
	ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
	Branch branch2=branchDao.saveBranch(hid,aid , branch);
	responseStructure.setMessage("branch saved successfully");
	responseStructure.setStatus(HttpStatus.CREATED.value());
	responseStructure.setData(branch2);
	return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
}
public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,Branch branch){
	Branch branch2=branchDao.updateBranch(id, branch);
	ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
	if(branch2!=null) {
		responseStructure.setMessage("updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(branch2);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}else {
		throw new IdNotFoundException("Branch is not found for this id");
	}
}
public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id){
	ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
	Branch branch=branchDao.deleteBranch(id);
	if(branch!=null) {
		responseStructure.setMessage("deleted successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(branch);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}else {
		throw new IdNotFoundException("Branch is not found for this id");
	}
	
}
public ResponseEntity<ResponseStructure<Branch>> getBranch(int id){
	ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
	Branch branch=branchDao.getBranchById(id);
	if(branch!=null) {
		responseStructure.setMessage("found successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(branch);
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}else {
		throw new IdNotFoundException("Branch is not found for this id");
	}
}
//public ResponseEntity<ResponseStructure<Branch>> getAllBranchByHospitalId(int h_id){
//	ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
//	List<Branch> branchs=branchDao.getByHospitalId(h_id);
//	if(branchs!=null) {
//		responseStructure.setMessage("found successfully");
//		responseStructure.setStatus(HttpStatus.FOUND.value());
//		for(Branch branch:branchs) {
//			responseStructure.setData(branch);	
//		}
//		
//		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);
//	}else {
//		throw new IdNotFoundException();
//	}
//}
public ResponseEntity<ResponseStructure<List<Branch>>> getBranchesByHid(int h_id) {
	ResponseStructure<List<Branch>> responseStructure=new ResponseStructure<>();
	List<Branch> branchs=branchDao.getBranchByHosId(h_id);
	if(branchs!=null) {
		responseStructure.setMessage("succesfully fetched all the branches");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(branchs);
	}
	return null;
}


}
