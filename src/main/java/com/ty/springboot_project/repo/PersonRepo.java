package com.ty.springboot_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_project.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
