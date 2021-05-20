package com.nabla.careermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nabla.careermanagement.entity.CareerManagement;
import com.nabla.careermanagement.exception.ResourceNotFoundException;
import com.nabla.careermanagement.repository.CareerRepository;

//defining the business logic  
@Service
public class CareerManagementService<CareerManagement> {
	@Autowired
	CareerRepository careerRepository;

	// getting all job opening details currently available
	public List<CareerManagement> getAllJobDetails() {
		List<CareerManagement> careerManagement = new ArrayList<CareerManagement>();
		careerRepository.findAll()
				.forEach(careerManagement1 -> careerManagement.add((CareerManagement) careerManagement1));
		return careerManagement;
	}

	// getting a specific job
	public CareerManagement getjobOpeningById(int id) {
		CareerManagement careerManagement = (CareerManagement) careerRepository.findById(id).get();
		if (careerManagement == null) {
			throw new ResourceNotFoundException("Please provide  id into path:");
		}
		return careerManagement;

	}

	// deleting a specific record
	public void delete(int id) {
		careerRepository.deleteById(id);
	}

	// updating a record
	public void update(com.nabla.careermanagement.entity.CareerManagement careerManagement, int jobOpeningId) {

		careerRepository.save(careerManagement);
	}

	// add new job details into db
	public void saveOrUpdate(com.nabla.careermanagement.entity.CareerManagement careerManagement) {

		careerRepository.save(careerManagement);
	}

}
