/**
 * 
 */
package com.example.demo.service;

import com.example.demo.model.BranchDTO;
import com.example.demo.model.TimeAvailabilityDTO;
import com.example.demo.model.VaccineDTO;
import com.example.demo.model.VaccineRequest;

/**
 * @author pisharma
 *
 */
public interface AvailabilityService {

	public BranchDTO getAllBranches();
	
	public VaccineDTO getAvailableVaccinesWithBranch();
	
	public VaccineDTO getAvailableVaccinesForBranch(Integer branchId);
	
	public TimeAvailabilityDTO getTimeAvailableForBranch(Integer branchId);
	
	public boolean scheduleVaccination(VaccineRequest vaccineRequest);
	
}
