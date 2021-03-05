package com.example.demo.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessResourceFailureException;

import com.example.demo.entity.Branch;
import com.example.demo.model.BranchDTO;
import com.example.demo.model.VaccineDTO;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.VaccineSchedularRepository;
import com.example.demo.service.impl.AvailabilityServiceImpl;


@RunWith(MockitoJUnitRunner.class)
class AvailabilityServiceTest {
	
	@Mock
	private BranchRepository branchRepository;
	
	@Mock
	private VaccineSchedularRepository vaccineSchedularRepository;
	
	@Mock
	NotificationService notificationService;
	
	@InjectMocks
	AvailabilityServiceImpl availabilityServiceImpl;

	@Before
    public void init() {
		MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getAllBranchesSuccessfully() {
		Branch branch1 = new Branch();
		branch1.setBranchLocation("New Delhi");
		branch1.setBranchName("Covid Vaccine Booth");
		branch1.setId(2);
		branch1.setTimeAvailabilityForVaccine(new Date());
		branch1.setVaccineCount(2000);
		
		Branch branch2 = new Branch();
		branch2.setBranchLocation("Ghaziabad");
		branch2.setBranchName("Covid Vaccine Booth");
		branch2.setId(3);
		branch2.setTimeAvailabilityForVaccine(new Date());
		branch2.setVaccineCount(4000);
		
		Branch branch3 = new Branch();
		branch3.setBranchLocation("Noida");
		branch3.setBranchName("Covid Vaccine Booth");
		branch3.setId(4);
		branch3.setTimeAvailabilityForVaccine(new Date());
		branch3.setVaccineCount(10000);
		
		List<Branch> branches = new ArrayList<>();
		branches.add(branch1);
		branches.add(branch2);
		branches.add(branch3);
		
		Mockito.when(branchRepository.findAll()).thenReturn(branches);
		
        BranchDTO model = availabilityServiceImpl.getAllBranches();
        
        assertNotNull(model);
        assertTrue(model.getBranches().size() == 3);
	}
	
	@Test
	public void getAllBranchesWithEmptyResultSuccessfully() {
		
		Mockito.when(branchRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
		
        BranchDTO model = availabilityServiceImpl.getAllBranches();
        
        assertNotNull(model);
        assertTrue(model.getBranches().size() == 0);
	}
	
	@Test(expected = DataAccessResourceFailureException.class)
	public void getAllBranchesWithDBException() {
		
		Mockito.when(branchRepository.findAll()).thenThrow(new DataAccessResourceFailureException("Couldn't connect To Database"));
		
        BranchDTO model = availabilityServiceImpl.getAllBranches();
        
	}
	
	
	@Test
	public void getAvailableVaccinesWithBranchSuccessfully() {
		Branch branch1 = new Branch();
		branch1.setBranchLocation("New Delhi");
		branch1.setBranchName("Covid Vaccine Booth");
		branch1.setId(2);
		branch1.setTimeAvailabilityForVaccine(new Date());
		branch1.setVaccineCount(2000);
		
		Branch branch2 = new Branch();
		branch2.setBranchLocation("Ghaziabad");
		branch2.setBranchName("Covid Vaccine Booth");
		branch2.setId(3);
		branch2.setTimeAvailabilityForVaccine(new Date());
		branch2.setVaccineCount(4000);
		
		Branch branch3 = new Branch();
		branch3.setBranchLocation("Noida");
		branch3.setBranchName("Covid Vaccine Booth");
		branch3.setId(4);
		branch3.setTimeAvailabilityForVaccine(new Date());
		branch3.setVaccineCount(10000);
		
		List<Branch> branches = new ArrayList<>();
		branches.add(branch1);
		branches.add(branch2);
		branches.add(branch3);
		
		Mockito.when(branchRepository.findAll()).thenReturn(branches);
		
        VaccineDTO model = availabilityServiceImpl.getAvailableVaccinesWithBranch();
        
        assertNotNull(model);
        assertTrue(model.getVaccineAvailability().size() == 3);
	}
	
	
	

}
