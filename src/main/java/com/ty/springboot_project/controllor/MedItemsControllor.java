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

import com.ty.springboot_project.dto.MedItems;
import com.ty.springboot_project.service.MedItemService;
import com.ty.springboot_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemsControllor {


	@Autowired
	private MedItemService medItemsService;
	
	@ApiOperation(value="SaveMedItems", notes = "api is used to save the MedItems for the given MedOrder id")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code= 404, message="Given MedOrder Id not Found")
	})
	@PostMapping("/savemedItems")
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@RequestBody MedItems medItems, @RequestParam int mid){
		return medItemsService.saveMedItems(medItems, mid);
	}
	

	@ApiOperation(value="UpdateMedItems", notes = "api is used to update the MedItems for the given MedItems id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code= 404, message="Given MedItems Id not Found")
	})
	@PutMapping("/updatemedItems")
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@RequestBody MedItems medItems, @RequestParam int mid){
		return medItemsService.updateMedItems(medItems, mid);
	}
	

	@ApiOperation(value="DeleteMedItems", notes = "api is used to delete the MedItems for the given MedItems id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given MedItems Id not Found")
	})
	@DeleteMapping("/deletemedItems")
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(@RequestParam int mid){
		return medItemsService.deleteMedItems(mid);
	}
	

	@ApiOperation(value="GetMedItems", notes = "api is used to Get the MedItems for the given MedItems id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given MedItems Id not Found")
	})
	@GetMapping("/getmedItems")
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(@RequestParam int mid){
		return medItemsService.getMedItemsById(mid);
	}
	

	@ApiOperation(value="GetMedItemsByMedOrder", notes = "api is used to Get the MedItems for the given MedOrder id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given MedOrder Id not Found")
	})
	@GetMapping("/getallmedItems")
	public ResponseEntity<ResponseStructure<List<MedItems>>> getAllMedItemsByMedOrder(@RequestParam int mid){
		return medItemsService.getAllMedItemsByMedOrder(mid);
	}

}
