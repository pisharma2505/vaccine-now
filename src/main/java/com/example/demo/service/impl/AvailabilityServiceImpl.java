/**
 * 
 */
package com.example.demo.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ScheduleVaccine;
import com.example.demo.model.Branch;
import com.example.demo.model.BranchDTO;
import com.example.demo.model.TimeAvailabilityDTO;
import com.example.demo.model.Vaccine;
import com.example.demo.model.VaccineDTO;
import com.example.demo.model.VaccineRequest;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.VaccineSchedularRepository;
import com.example.demo.response.Response;
import com.example.demo.response.VaccineResponse;
import com.example.demo.service.AvailabilityService;
import com.example.demo.service.NotificationService;

/**
 * @author pisharma
 *
 */
@Service
public class AvailabilityServiceImpl implements AvailabilityService {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private VaccineSchedularRepository vaccineSchedularRepository;
	
	
	@Autowired
	NotificationService notificationService;

	@Override
	public BranchDTO getAllBranches() throws Exception{
		
		List<com.example.demo.entity.Branch> branches = branchRepository.findAll();
		BranchDTO model = null;
		if(!branches.isEmpty()) {
			 model = new BranchDTO();
			for(com.example.demo.entity.Branch entity : branches) {
				Branch element = new Branch();
				element.setName(entity.getBranchName());
				element.setLocation(entity.getBranchLocation());
				model.getBranches().add(element);
			}
		}
		return model;
	}
		
	@Override
	public VaccineDTO getAvailableVaccinesWithBranch() throws Exception{
		List<com.example.demo.entity.Branch> branches = branchRepository.findAll();
		VaccineDTO model = null;
		if(!branches.isEmpty()) {
			model = new VaccineDTO();
			for(com.example.demo.entity.Branch entity : branches) {
				Vaccine element = new Vaccine();
				element.setAvailibilityInBranch(entity.getVaccineCount());
				element.setBranch(entity.getBranchName() + "," + entity.getBranchLocation());
				model.getVaccineAvailability().add(element);
			}
		}
		return model;
	}

	@Override
	public VaccineResponse getAvailableVaccinesForBranch(Integer branchId) throws Exception{
		Response response = new Response();
		if(branchId == null || "".equals(branchId)) {
			response.setMessage("Invalid Branch Id");
			return response;
		}
		Optional<com.example.demo.entity.Branch> entity = branchRepository.findById(branchId);
		VaccineDTO vaccineResponse = null;
		if(entity.isPresent()) {
			vaccineResponse = new VaccineDTO();
				Vaccine element = new Vaccine();
				element.setAvailibilityInBranch(entity.get().getVaccineCount());
				element.setBranch(entity.get().getBranchName() + "," + entity.get().getBranchLocation());
				vaccineResponse.getVaccineAvailability().add(element);
				return vaccineResponse;
		}
		response.setMessage("Branch doesn't exists.");
		return response;
	}

	@Override
	public  VaccineResponse getTimeAvailableForBranch(Integer branchId) throws Exception{
		Response response = new Response();
		if(branchId == null || "".equals(branchId)) {
			response.setMessage("Invalid Branch Id");
			return response;
		}
		Optional<com.example.demo.entity.Branch> entity = branchRepository.findById(branchId);
		TimeAvailabilityDTO vaccineResponse = null;
		if(entity.isPresent()) {
			vaccineResponse = new TimeAvailabilityDTO();
		    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    vaccineResponse.setAvailibilityInBranch(dateFormat.format(entity.get().getTimeAvailabilityForVaccine().getTime()));
		    vaccineResponse.setBranch(entity.get().getBranchName() + "," + entity.get().getBranchLocation());
			return  vaccineResponse;
		}else {
			response.setMessage("Branch doesn't exists.");
			return response;
		}
		
	}

	@Override
	public Response scheduleVaccination(VaccineRequest vaccineRequest) throws Exception{
		Response response = new Response();
		if(vaccineRequest.getBranchId() == null) {
			response.setMessage("Invalid Branch Id");
			return response;
		}else if(vaccineRequest.getPaymentMode() == null){
			response.setMessage("Please provide valid payment model.");
			return response;
		}else if(vaccineRequest.getUserID() == null){
			response.setMessage("Please provide valid userId.");
			return response;
		}else if(vaccineRequest.getTimeSlot() == null){
			response.setMessage("Please provide valid time slot.");
			return response;
		}
		Optional<com.example.demo.entity.Branch> entity = branchRepository.findById(vaccineRequest.getBranchId());
		
		if(entity.isPresent()) {
			long differenceInDuration = vaccineRequest.getTimeSlot().getTime() - entity.get().getTimeAvailabilityForVaccine().getTime(); 
			long difference_In_Minutes = (differenceInDuration/(1000 * 60))% 60; 
			if(difference_In_Minutes >= 15L) {
				ScheduleVaccine scheduleVaccine = new ScheduleVaccine();
				scheduleVaccine.setBranchId(vaccineRequest.getBranchId());
				scheduleVaccine.setPaymentMode(vaccineRequest.getPaymentMode());
				scheduleVaccine.setUserId(vaccineRequest.getUserID());
				scheduleVaccine.setTimeSlot(vaccineRequest.getTimeSlot());
				scheduleVaccine.setNotified("Y");
				vaccineSchedularRepository.saveAndFlush(scheduleVaccine);
				notificationService.triggerNotification();
				response.setMessage("Vaccine Scheduled is successful.Please check email for further details.");
				return response;	
				
			}else {
				response.setMessage("Time slot doesn't exists.");
				return response;
			}
		}
		response.setMessage("Branch doesn't exists.");
		return response;
	}
	

}
