package com.nabla.careermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nabla.careermanagement.entity.CareerManagement;

public interface CareerRepository extends JpaRepository<CareerManagement, Integer> {

}
