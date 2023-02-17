package com.ty.springboot_project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_project.dto.MedItems;
import com.ty.springboot_project.dto.MedOrder;

public interface MedItemsRepo extends JpaRepository<MedItems, Integer>{
	@Query("select m from MedItems m where m.medOrder=?1")
	public List<MedItems> getByMedOrder(MedOrder medOrder);

}