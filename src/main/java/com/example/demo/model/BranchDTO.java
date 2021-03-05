/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pisharma
 *
 */
public class BranchDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	List<Branch> branches;
	
	public BranchDTO() {
		this.branches = new ArrayList<>();
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	
	

}
