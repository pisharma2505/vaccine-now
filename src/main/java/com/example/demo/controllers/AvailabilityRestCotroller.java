/**
 * 
 */
package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BranchDTO;
import com.example.demo.model.TimeAvailabilityDTO;
import com.example.demo.model.VaccineDTO;
import com.example.demo.model.VaccineRequest;
import com.example.demo.service.AvailabilityService;

/**
 * @author pisharma
 *
 */
@RestController
@RequestMapping("/vaccine-now")
public class AvailabilityRestCotroller {

	@Autowired(required = true)
	private AvailabilityService availabilityService;

	@GetMapping("/branches")
	public @ResponseBody BranchDTO getAllBranches() {
		return availabilityService.getAllBranches();
	}

	@GetMapping("/branch/vaccines")
	public @ResponseBody VaccineDTO getAvailableVaccinesWithBranch() {
		return availabilityService.getAvailableVaccinesWithBranch();
	}

	@GetMapping("/branch/{branchId}/vaccines")
	public @ResponseBody VaccineDTO getAvailableVaccinesForBranch(@PathVariable("branchId") Integer branchId) {
		return availabilityService.getAvailableVaccinesForBranch(branchId);
	}

	@GetMapping("/branch/{branchId}/availability")
	public @ResponseBody TimeAvailabilityDTO getTimeAvailableForBranch(@PathVariable("branchId") Integer branchId) {
		return availabilityService.getTimeAvailableForBranch(branchId);
	}

	@PostMapping("/schedule/vaccine")
	public ResponseEntity<String> scheduleVaccinationForUserWithAvailableTimeSlot(
			@RequestBody VaccineRequest vaccineRequest) {
		boolean isSheduled = availabilityService.scheduleVaccination(vaccineRequest);
		if (isSheduled) {
			return new ResponseEntity<>("Vaccine Scheduled is successful", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
