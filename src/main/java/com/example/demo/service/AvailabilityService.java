/**
 * 
 */
package com.example.demo.service;

import com.example.demo.model.BranchDTO;
import com.example.demo.model.VaccineDTO;
import com.example.demo.model.VaccineRequest;
import com.example.demo.response.Response;
import com.example.demo.response.VaccineResponse;

/**
 * @author pisharma
 *
 */
public interface AvailabilityService {

	public BranchDTO getAllBranches() throws Exception;
	
	public VaccineDTO getAvailableVaccinesWithBranch() throws Exception;
	
	public VaccineResponse getAvailableVaccinesForBranch(Integer branchId) throws Exception;
	
	public VaccineResponse getTimeAvailableForBranch(Integer branchId) throws Exception;
	
	public Response scheduleVaccination(VaccineRequest vaccineRequest) throws Exception;
	
}
