package com.ty.springboot_project.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.dto.Hospital;

public interface BarnchRepo extends JpaRepository<Branch, Integer> {
	@Query("select b from Branch b where b.hospital=?1")
	public List<Branch> getByHospitalId(Hospital hospital);

	
}
