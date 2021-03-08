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

import lombok.Data;

/**
 * @author pisharma
 *
 */

@Entity
@Data
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

	

}
