package com.nabla.careermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nabla.careermanagement.entity.CareerManagement;
import com.nabla.careermanagement.exception.ResourceNotFoundException;
import com.nabla.careermanagement.service.CareerManagementService;

@RestController
@CrossOrigin(origins = "*")
public class CareerManagementServiceController {

	// autowire the CareerManagementService class
	@Autowired
	CareerManagementService<CareerManagement> careerManagementService;

	// creating a get mapping that retrieves all the all jobopening detail from the
	@GetMapping("/JobOpeningAvailable")
	public ResponseEntity<List<CareerManagement>> getAllJobOpening() {
		List<CareerManagement> list = careerManagementService.getAllJobDetails();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	// check current status
	@GetMapping("/JobOpeningAvailable/{jobOpeningId}")
	public CareerManagement getJobDetails(@PathVariable("jobOpeningId") int jobOpeningId) {
		try {
			return careerManagementService.getjobOpeningById(jobOpeningId);
		} catch (Exception ex) {
			throw new ResourceNotFoundException( jobOpeningId+" " +"this Id record not available please try with another id:");
		}

	}

	// creating a delete mapping that deletes a specified job details
	@DeleteMapping("/deleteExistingJobDetails/{jobOpeningId}")
	public void deleteJobDetails(@PathVariable("jobOpeningId") int jobOpeningId) {
		try {
			careerManagementService.delete(jobOpeningId);

		} catch (Exception e) {
			throw new ResourceNotFoundException(jobOpeningId + " " + "this Id not available please try with other id:");
		}
	}

	// creating post mapping that post the new job opening detail in the database
	@PostMapping("/addNewJobOpening")
	public ResponseEntity<CareerManagement> addNewJobOpeningDetails(
			@Valid @RequestBody CareerManagement careerManagement) {

		try {
			this.careerManagementService.saveOrUpdate(careerManagement);

			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// creating put mapping that updates the jobdetails
	@PutMapping("/updateExistingJob")
	public ResponseEntity<CareerManagement> updateExistingJobDetails(
			@Valid @RequestBody CareerManagement careerManagement) {
		try {
			this.careerManagementService.saveOrUpdate(careerManagement);
			return ResponseEntity.ok().body(careerManagement);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
