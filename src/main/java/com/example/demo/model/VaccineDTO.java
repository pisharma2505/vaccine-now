/**
 * 
 */
package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.response.VaccineResponse;

import lombok.Data;

/**
 * @author pisharma
 *
 */
@Data
public class VaccineDTO implements VaccineResponse{
	
	
	List<Vaccine> vaccineAvailability;
	
	public VaccineDTO() {
		this.vaccineAvailability = new ArrayList<>();
	}

	


}
