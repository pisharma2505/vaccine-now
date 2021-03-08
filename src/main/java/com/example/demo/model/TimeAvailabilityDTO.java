/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;

import com.example.demo.response.VaccineResponse;

import lombok.Data;

/**
 * @author pisharma
 *
 */
@Data
public class TimeAvailabilityDTO implements Serializable, VaccineResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String branch;

	private String availibilityInBranch;

	

}
