package com.cg.patient.service;

import java.util.List;

import com.cg.patient.entity.PatientEntity;
import com.cg.patient.exception.PatientException;

public interface PatientService {
	
	public List<PatientEntity> getAllPatients();
	public PatientEntity getPatientById(int id) throws PatientException;
	public PatientEntity getPatientByNumber(String number) throws PatientException;
	public PatientEntity addPatient(PatientEntity patient) throws PatientException;
	public PatientEntity updatePatient(int id,PatientEntity patient) throws PatientException;
	public PatientEntity getPatientByDoctorId(int id) throws PatientException;
	public void deletePatient(int id);
	

}
