/**
 * 
 */
package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author pisharma
 *
 */
@Component
public class VaccineDTO {
	
	
	List<Vaccine> vaccineAvailability;
	
	public VaccineDTO() {
		this.vaccineAvailability = new ArrayList<>();
	}

	public List<Vaccine> getVaccineAvailability() {
		return vaccineAvailability;
	}

	public void setVaccineAvailability(List<Vaccine> vaccineAvailability) {
		this.vaccineAvailability = vaccineAvailability;
	}


}
