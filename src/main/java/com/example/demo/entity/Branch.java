/**
 * 
 */
package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author pisharma
 *
 */

@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "BRANCH_NAME")
	private String branchName;
	
	@Column(name = "BRANCH_LOCATION")
	private String branchLocation;
	
	@Column(name= "VACCINE_COUNT",columnDefinition = "NUMERIC(19,0)")
	private int vaccineCount;
	
	@Column(name= "TIME_AVAILABILITY_FOR_VACCINE")
	private Date timeAvailabilityForVaccine;

	public Branch() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}

	public Integer getVaccineCount() {
		return vaccineCount;
	}

	public void setVaccineCount(Integer vaccineCount) {
		this.vaccineCount = vaccineCount;
	}

	public Date getTimeAvailabilityForVaccine() {
		return timeAvailabilityForVaccine;
	}

	public void setTimeAvailabilityForVaccine(Date timeAvailabilityForVaccine) {
		this.timeAvailabilityForVaccine = timeAvailabilityForVaccine;
	}

}
