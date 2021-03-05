/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ScheduleVaccine;

/**
 * @author pisharma
 *
 */
@Repository
public interface VaccineSchedularRepository  extends JpaRepository<ScheduleVaccine, Integer>{

}
