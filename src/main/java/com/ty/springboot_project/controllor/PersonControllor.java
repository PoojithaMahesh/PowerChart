package com.ty.springboot_project.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_project.dto.Person;
import com.ty.springboot_project.service.PersonService;
import com.ty.springboot_project.util.ResponseStructure;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonControllor {

	@Autowired
	private PersonService service;
	
	@ApiOperation(value="SavePerson", notes = "api is used to save the Person")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "Successfully created")
	})
	@PostMapping("/saveperson")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person){
		return service.savePerson(person);
	}


	@ApiOperation(value="updatePerson", notes = "api is used to update the Person for the given Person id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully updated"),
			@ApiResponse(code= 404, message="Given Person Id not Found")
	})
	@PutMapping("/updateperson")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id,@RequestBody Person person){
		return service.updatePerson(id, person);
	}
	

	@ApiOperation(value="DeletePerson", notes = "api is used to delete the Person for the given Person id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given Person Id not Found")
	})
	@DeleteMapping("/deleteperson")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id){
		return service.deletePerson(id);
	}
	
	
	@ApiOperation(value="GetPerson", notes = "api is used to Get the Person for the given Person id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given Person Id not Found")
	})
	@GetMapping("/getperson")
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id){
		return service.getPersonById(id);
	}

}

