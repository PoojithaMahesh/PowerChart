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
import com.ty.springboot_project.dto.Hospital;
import com.ty.springboot_project.service.HospitalService;
import com.ty.springboot_project.util.ResponseStructure;
import javax.validation.Valid;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalControllor {
	
	@Autowired
	private HospitalService service;
	
	
	@ApiOperation(value="SaveHospital", notes = "api is used to save the Hospital")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "Successfully created")
	})
	@PostMapping("/savehospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid@RequestBody Hospital hospital){
		return service.saveHospital(hospital);
	}


	@ApiOperation(value="updateHospital", notes = "api is used to update the Hospital for the given Hospital id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully updated"),
			@ApiResponse(code= 404, message="Given Hospital Id not Found")
	})
	@PutMapping("/updatehospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,@RequestBody Hospital hospital){
		return service.updateHospital(id,hospital);
	}
	
	@ApiOperation(value="DeleteHospital", notes = "api is used to delete the Hospital for the given Hospital id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given Hospital Id not Found")
	})
	@DeleteMapping("/deletehospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id){
		return service.deleteHospital(id);
	}
	
	
	@ApiOperation(value="GetHospital", notes = "api is used to Get the Hospital for the given Hospital id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given Hospital Id not Found")
	})
	@GetMapping("/gethospital")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id){
		return service.getHospitalById(id);
	}

}
