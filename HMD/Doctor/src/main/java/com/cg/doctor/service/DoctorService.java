package com.cg.doctor.service;

import java.util.List;

import com.cg.doctor.entity.DoctorEntity;
import com.cg.doctor.exception.DoctorException;

public interface DoctorService {
	
	public List<DoctorEntity> getAllDoctors();
	
	public DoctorEntity getDoctorById(int id) throws DoctorException;
	
	public List<DoctorEntity> getDoctorByPatientId(int patientId) throws DoctorException;
	
	public List<DoctorEntity> getDoctorByMedicalId(int medicalId) throws DoctorException;
	
	public DoctorEntity addDoctor(DoctorEntity addDoctor);
	
	public DoctorEntity updateDoctor(int id,DoctorEntity editDoctor) throws DoctorException;
	
	public void deleteDoctor(int id);
	

}
