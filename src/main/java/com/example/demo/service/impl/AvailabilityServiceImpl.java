/**
 * 
 */
package com.example.demo.service.impl;

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
	public BranchDTO getAllBranches() {
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
	public VaccineDTO getAvailableVaccinesWithBranch() {
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
	public VaccineDTO getAvailableVaccinesForBranch(Integer branchId) {
		Optional<com.example.demo.entity.Branch> entity = branchRepository.findById(branchId);
		VaccineDTO model = null;
		if(entity.isPresent()) {
			model = new VaccineDTO();
				Vaccine element = new Vaccine();
				element.setAvailibilityInBranch(entity.get().getVaccineCount());
				element.setBranch(entity.get().getBranchName() + "," + entity.get().getBranchLocation());
				model.getVaccineAvailability().add(element);
		}
		return model;
	}

	@Override
	public TimeAvailabilityDTO getTimeAvailableForBranch(Integer branchId) {
		Optional<com.example.demo.entity.Branch> entity = branchRepository.findById(branchId);
		TimeAvailabilityDTO model = null;
		if(entity.isPresent()) {
			model = new TimeAvailabilityDTO();
				model.setAvailibilityInBranch(entity.get().getTimeAvailabilityForVaccine());
				model.setBranch(entity.get().getBranchName() + "," + entity.get().getBranchLocation());
		}
		return model;
	}

	@Override
	public boolean scheduleVaccination(VaccineRequest vaccineRequest) {
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
				return true;	
				
			}else {
				return false;
			}
		}
		return false;
	}
	

}
