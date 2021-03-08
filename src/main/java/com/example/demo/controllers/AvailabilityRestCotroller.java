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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.VaccineRequest;
import com.example.demo.response.Response;
import com.example.demo.response.VaccineResponse;
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
	public ResponseEntity<VaccineResponse> getAllBranches() {
		try {
			VaccineResponse response = availabilityService.getAllBranches();
			return new ResponseEntity<VaccineResponse>(response, HttpStatus.OK);
		}catch(Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Branches not found.", exception.getCause());
		}
		
	}

	@GetMapping("/branch/vaccines")
	public ResponseEntity<VaccineResponse> getAvailableVaccinesWithBranch() {
		try {
			VaccineResponse response = availabilityService.getAvailableVaccinesWithBranch();
			return new ResponseEntity<VaccineResponse>(response, HttpStatus.OK);
		}catch(Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Available vaccines not found.", exception.getCause());
		}
		
	}

	@GetMapping("/branch/{branchId}/vaccines")
	public ResponseEntity<VaccineResponse> getAvailableVaccinesForBranch(@PathVariable("branchId") Integer branchId) {
		try {
			VaccineResponse response = availabilityService.getAvailableVaccinesForBranch(branchId);
			return new ResponseEntity<VaccineResponse>(response, HttpStatus.OK);
		}catch(Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Available vaccines for branch id : "+branchId+" not found.", exception.getCause());
		}
		
	}

	@GetMapping("/branch/{branchId}/availability")
	public ResponseEntity<VaccineResponse> getTimeAvailableForBranch(@PathVariable("branchId") Integer branchId) {
		try {
			VaccineResponse response = availabilityService.getTimeAvailableForBranch(branchId);
			return  new ResponseEntity<VaccineResponse>(response, HttpStatus.OK);
		}catch(Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Availability for branch id"+branchId+"not found.",exception.getCause());
		}
		
	}

	@PostMapping("/schedule/vaccine")
	public ResponseEntity<Response> scheduleVaccinationForUserWithAvailableTimeSlot(
			@RequestBody VaccineRequest vaccineRequest) {
		try {
			Response response = availabilityService.scheduleVaccination(vaccineRequest);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}catch(Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Schedule couldn't done.",exception.getCause());
		}
		
	}

}
