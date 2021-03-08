/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author pisharma
 *
 */
@Component
@Data
public class Vaccine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String branch;
	
	private Integer availibilityInBranch;

}
