package com.ty.springboot_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_project.dto.Address;
import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.dto.Hospital;
import com.ty.springboot_project.repo.BarnchRepo;

@Repository
public class BranchDao {
	@Autowired
	private BarnchRepo repo;
	@Autowired
	private HospitalDao dao;
	@Autowired
	private AddressDao addressDao;
	
	public Branch saveBranch(int hid,int aid,Branch branch) {
		Hospital hospital=dao.getById(hid);
		Address address=addressDao.getById(aid);
		branch.setHospital(hospital);
		branch.setAddress(address);
		return repo.save(branch);
	}
	public Branch updateBranch(int id,Branch branch) {
		
		if(repo.findById(id).isPresent()) {
			Branch branch2=repo.findById(id).get();
			branch.setId(id);
			branch.setHospital(branch2.getHospital());
			branch.setAddress(branch2.getAddress());
			return repo.save(branch);
			
		}
		return null;
	}
	public Branch deleteBranch(int id) {
		if(repo.findById(id).isPresent()) {
			Branch branch=repo.findById(id).get();
			 repo.delete(branch);
			 return branch;
		}
		return null;
	}

	public Branch getBranchById(int id) {
		if(repo.findById(id).isPresent()) {
			Branch branch=repo.findById(id).get();
			return branch;
		}
		return null;
	}
//	public List<Branch> getByHospitalId(int h_id) {
//		return repo.getByHospitalId(h_id);
//	}
//    public Branch getAllBranches(int hid) {
//    	Hospital hospital=dao.getById(hid);
//    	if(hospital!=null) {
//    		Branch branch=repo.get
//    	}
//    }
	public List<Branch> getBranchByHosId(int h_id) {
	Hospital hospital=dao.getById(h_id);
	if(hospital!=null) {
		List<Branch> branchs=repo.getByHospitalId(hospital);
		return branchs;
	}
		return null;
	}
}
