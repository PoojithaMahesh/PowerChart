package com.ty.springboot_project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.dto.MedOrder;

public interface MedOrderRepo  extends JpaRepository<MedOrder, Integer>{
	@Query("select m from MedOrder m where m.encounter=?1")
	public List<MedOrder> getByEncounter(Encounter encounter);
	
	

}
