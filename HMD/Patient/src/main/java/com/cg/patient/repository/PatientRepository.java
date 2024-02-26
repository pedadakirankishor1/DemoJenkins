package com.cg.patient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.patient.entity.PatientEntity;

@Repository
public interface PatientRepository extends MongoRepository<PatientEntity, Integer>{

}
