/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author pisharma
 *
 */
@Component
public class Vaccine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String branch;
	
	private Integer availibilityInBranch;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Integer getAvailibilityInBranch() {
		return availibilityInBranch;
	}

	public void setAvailibilityInBranch(Integer availibilityInBranch) {
		this.availibilityInBranch = availibilityInBranch;
	}
	
	
	
	

}
