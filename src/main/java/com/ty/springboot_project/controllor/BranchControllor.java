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

import com.ty.springboot_project.dto.Branch;
import com.ty.springboot_project.dto.Hospital;
import com.ty.springboot_project.service.BranchService;
import com.ty.springboot_project.util.ResponseStructure;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchControllor {
	
	@Autowired
	private BranchService branchService;
	
	@ApiOperation(value="SaveBranch", notes = "api is used to save the branch for the given hospital id")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code= 404, message="Given Hospital Id not Found"),
			@ApiResponse(code= 404, message="Given address Id not Found")
	})
	
	@PostMapping("/savebranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestParam int hid,@RequestParam int aid,@RequestBody Branch branch){
		return branchService.saveBranch(hid, aid, branch);
	}
	

	@ApiOperation(value="UpdateBranch", notes = "api is used to update the branch for the given hospital id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code= 404, message="Given branch Id not Found")
	})
	@PutMapping("/updatebranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int bid,@RequestBody Branch branch){
		return branchService.updateBranch(bid, branch);
	}
	
	@ApiOperation(value="DeleteBranch", notes = "api is used to delete the branch for the given Branch id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given branch Id not Found")
	})
	
	@DeleteMapping("/deletebranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id){
		return branchService.deleteBranch(id);
	}
	
	@ApiOperation(value="GetBranch", notes = "api is used to Get the branch for the given Branch id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given branch Id not Found")
	})
	@GetMapping("/getbranch")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int id){
		return branchService.getBranch(id);
	}
	
	
	@ApiOperation(value="GetBranch", notes = "api is used to Get all the branch for the given Hospital id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully fetched"),
			@ApiResponse(code= 404, message="Given branch Id not Found")
	})
	@GetMapping("/getallbranch")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospital(@RequestParam int hid){
		return branchService.getBranchesByHid(hid);
	}
	
	
	
}


