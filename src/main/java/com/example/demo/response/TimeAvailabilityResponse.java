package com.example.demo.response;

import com.example.demo.model.TimeAvailabilityDTO;

import lombok.Data;

@Data
public class TimeAvailabilityResponse implements VaccineResponse {
	
	private TimeAvailabilityDTO availability;

	

}
