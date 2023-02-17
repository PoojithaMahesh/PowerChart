package com.ty.springboot_project.controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_project.dto.MedOrder;
import com.ty.springboot_project.service.MedOrderService;
import com.ty.springboot_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderControllor {
	
	@Autowired
	private MedOrderService medOrderService;
	
	@ApiOperation(value="SaveMedOrder", notes = "api is used to save the MedOrder for the given encounter id")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code= 404, message="Given Encounter Id not Found")
	})
	@PostMapping("/savemedorder")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder, @RequestParam int eid){
		return medOrderService.saveMedOrder(medOrder, eid);
	}
	

	@ApiOperation(value="UpdateMedOrder", notes = "api is used to update the MedOrder for the given MedOrder id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code= 404, message="Given MedOrder Id not Found")
	})
	@PutMapping("/updatemedorder")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder, @RequestParam int mid){
		return medOrderService.updateMedOrder(medOrder, mid);
	}
	

	@ApiOperation(value="DeleteMedOrder", notes = "api is used to delete the MedOrder for the given MedOrder id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given MedOrder Id not Found")
	})
	@DeleteMapping("/deletemedorder")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@RequestParam int mid){
		return medOrderService.deleteMedOrder(mid);
	}
	

	@ApiOperation(value="GetMedOrder", notes = "api is used to Get the MedOrder for the given MedOrder id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given MedOrder Id not Found")
	})
	@GetMapping("/getmedorder")
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@RequestParam int mid){
		return medOrderService.getMedOrderById(mid);
	}
	


	@ApiOperation(value="GetMedOrderByEncounter", notes = "api is used to Get the MedOrder for the given Encounter id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given encounter Id not Found")
	})
	@GetMapping("/getallmedorder")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrderByEncounter(@RequestParam int eid){
		return medOrderService.getAllMedOrderByEncounter(eid);
	}

}
