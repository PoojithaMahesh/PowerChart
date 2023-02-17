package com.ty.springboot_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_project.dto.Encounter;

public interface EncounterRepo  extends JpaRepository<Encounter, Integer>{

}
