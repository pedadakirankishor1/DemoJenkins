package com.cg.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.patient.entity.PatientEntity;
import com.cg.patient.exception.PatientException;
import com.cg.patient.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientRepository Repo;

	@Override
	public List<PatientEntity> getAllPatients() {
		List<PatientEntity> patientList = Repo.findAll();
		
		return patientList;
	}

	@Override
	public PatientEntity getPatientById(int id) throws PatientException {
		Optional<PatientEntity> patientList = Repo.findById(id);
//		PatientEntity  patient=null;
		if(patientList.isPresent()) {
			PatientEntity patient = patientList.get();
			return patient;
		}
		throw new PatientException("user with phone number "+id+" not found");
		
		
	}

	@Override
	public PatientEntity getPatientByNumber(String number) throws PatientException {
		List<PatientEntity> patientList = Repo.findAll();
		for(PatientEntity patient:patientList) {
			if(patient.getPhoneNumber().equalsIgnoreCase(number)) {
				return patient;
			}
		}
		throw new PatientException("user with phone number "+number+" not found");
	}

	@Override
	public PatientEntity addPatient(PatientEntity patient) throws PatientException {
		List<PatientEntity> patientList = Repo.findAll();
		for(PatientEntity patients:patientList) {
			if(!patients.getPhoneNumber().equals(patient.getPatientName())) {
				return Repo.save(patient);
				
			}
		}
		
		throw new PatientException("user data alread exisit");
	}

	@Override
	public PatientEntity updatePatient(int id, PatientEntity patient) throws PatientException {
		PatientEntity patients = Repo.findById(id).orElseThrow( ()-> new PatientException("user not found"));
		patients.setPatientName(patient.getPatientName());
		patients.setDescription(patient.getDescription());
		patients.setAge(patient.getAge());
		patients.setDoctorId(patient.getDoctorId());
		patients.setPhoneNumber(patient.getPhoneNumber());
		return Repo.save(patients);
	}

	@Override
	public PatientEntity getPatientByDoctorId(int id) throws PatientException {
		List<PatientEntity> patient = Repo.findAll();
		for(PatientEntity patients : patient) {
			if(patients.getDoctorId() ==id) {
				return patients;
			}
		}
		throw new PatientException("user data dosen't exisit");
	}

	@Override
	public void deletePatient(int id) {
		
		Repo.deleteById(id);
	}

	

}
