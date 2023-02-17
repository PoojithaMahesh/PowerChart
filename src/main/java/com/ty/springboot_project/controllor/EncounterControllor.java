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
import com.ty.springboot_project.dto.Encounter;
import com.ty.springboot_project.service.EncounterService;
import com.ty.springboot_project.util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterControllor {
	
	@Autowired
	private EncounterService service;
	
	@ApiOperation(value="SaveEncounter", notes = "api is used to save the Encounter for the Given barnch id")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "Given Person Id not found"),
			@ApiResponse(code = 404, message = "Given Branch Id not found")
	})
	@PostMapping("/saveencounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,@RequestParam int pid, @RequestParam int bid ){
		return service.saveEncounter(pid, bid, encounter);
	}
	
	@ApiOperation(value="updateEncounter", notes = "api is used to update the Encounter for the given Encounter id and Branch Id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully updated"),
			@ApiResponse(code = 404, message="Given Encounter Id not Found"),
			@ApiResponse(code = 404, message = "Given Branch Id not found")
	})
	@PutMapping("/updateencounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,@RequestParam int eid, @RequestParam int bid ){
		return service.updateEncounter(encounter, eid, bid);
	}

	@ApiOperation(value="DeleteEncounter", notes = "api is used to delete the encounter for the given encounter id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given encounter Id not Found")
	})
	@DeleteMapping("/deleteencounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int eid ){
		return service.deleteEncounter(eid);
	}

	
	@ApiOperation(value="GetEncounter", notes = "api is used to Get the encounter for the given encounter id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given encounter Id not Found")
	})
	@GetMapping("/getencounter")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter( @RequestParam int eid ){
		return service.getEncounter(eid);
	}

}
