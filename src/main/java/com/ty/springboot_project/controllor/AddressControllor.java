package com.ty.springboot_project.controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_project.dto.Address;
import com.ty.springboot_project.service.AddressService;
import com.ty.springboot_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressControllor {
	
	@Autowired
	private AddressService service;
	
	@ApiOperation(value="SaveAddress", notes = "api is used to save the Address")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "Successfully created")
	})
	@PostMapping("/saveaddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address){
		return service.saveAddress(address);
	}


	@ApiOperation(value="updateAddress", notes = "api is used to update the address for the given address id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully updated"),
			@ApiResponse(code= 404, message="Given address Id not Found")
	})
	@PutMapping("/updateaddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int id,@RequestBody Address address){
		return service.updateAddress(id,address);
	}
	
	
	@ApiOperation(value="DeleteAddress", notes = "api is used to delete the address for the given address id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given address Id not Found")
	})
	@DeleteMapping("/deleteaddress")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int id){
		return service.deleteAddress(id);
	}
	
	@ApiOperation(value="GetAddress", notes = "api is used to Get the address for the given address id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given address Id not Found")
	})
	@GetMapping("/getaddress")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int id){
		return service.getAddress(id);
	}

	
}
