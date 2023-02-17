package com.ty.springboot_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_project.dto.Address;

public interface AddressRepo  extends JpaRepository<Address, Integer>{

}
