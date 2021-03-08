/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.response.VaccineResponse;

import lombok.Data;

/**
 * @author pisharma
 *
 */
@Data
public class BranchDTO implements Serializable, VaccineResponse {
	
	private static final long serialVersionUID = 1L;
	
	List<Branch> branches;
	
	public BranchDTO() {
		this.branches = new ArrayList<>();
	}
	
}
