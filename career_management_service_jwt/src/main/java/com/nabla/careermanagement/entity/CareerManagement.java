package com.nabla.careermanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table
public class CareerManagement {
	// Defining book id as primary key
	@Id
	private int jobOpeningId;
	
	private String jobProfile;
	
	private String jobDescription;
	
	private String skillRequired;

	private String eligibilityCriteria;

	public int getJobOpeningId() {
		return jobOpeningId;
	}

	public void setJobOpeningId(int jobOpeningId) {
		this.jobOpeningId = jobOpeningId;
	}

	public String getJobProfile() {
		return jobProfile;
	}

	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getSkillRequired() {
		return skillRequired;
	}

	public void setSkillRequired(String skillRequired) {
		this.skillRequired = skillRequired;
	}

	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}

	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	public CareerManagement(int jobOpeningId, String jobProfile, String jobDescription, String skillRequired,
			String eligibilityCriteria) {
		super();
		this.jobOpeningId = jobOpeningId;
		this.jobProfile = jobProfile;
		this.jobDescription = jobDescription;
		this.skillRequired = skillRequired;
		this.eligibilityCriteria = eligibilityCriteria;
	}

	public CareerManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

}
