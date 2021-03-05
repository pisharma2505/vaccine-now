/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author pisharma
 *
 */
@Component
public class TimeAvailabilityDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String branch;

	private Date availibilityInBranch;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getAvailibilityInBranch() {
		return availibilityInBranch;
	}

	public void setAvailibilityInBranch(Date availibilityInBranch) {
		this.availibilityInBranch = availibilityInBranch;
	}

}
