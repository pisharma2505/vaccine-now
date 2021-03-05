/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author pisharma
 *
 */
@Component
public class Branch implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	private String name;
	private String location;
	//private List<Vaccine> availableVaccines;
	//private Integer availableVaccines;
	//private List<Date> availableTimeSlots;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	/*public List<Date> getAvailableTimeSlots() {
		return availableTimeSlots;
	}
	public void setAvailableTimeSlots(List<Date> availableTimeSlots) {
		this.availableTimeSlots = availableTimeSlots;
	}
	public Integer getAvailableVaccines() {
		return availableVaccines;
	}
	public void setAvailableVaccines(Integer availableVaccines) {
		this.availableVaccines = availableVaccines;
	} */

}
