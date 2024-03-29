package com.cg.doctor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.doctor.entity.DoctorEntity;

@Repository
public interface DoctorRepository extends MongoRepository<DoctorEntity, Integer> {

}
