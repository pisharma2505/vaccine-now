/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author pisharma
 *
 */
@Component
@Data
public class VaccineRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userID;
	
	private Integer branchId;
	
	private Date timeSlot;
	
	private String paymentMode;
	
}
