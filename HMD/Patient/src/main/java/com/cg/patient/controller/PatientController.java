package com.cg.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.patient.entity.PatientEntity;
import com.cg.patient.exception.PatientException;
import com.cg.patient.service.PatientServiceImpl;

@RestController
@RequestMapping("/api/p")

public class PatientController {
	@Autowired
	PatientServiceImpl impl;
	
	
	@GetMapping("/getAllPatients")
	public List<PatientEntity> getAllPatients(){
		return impl.getAllPatients();
	}
	
	
	@GetMapping("/getPatientById/{id}")
	public PatientEntity getPatientById(@PathVariable int id) throws PatientException{
		return impl.getPatientById(id);
	}
	
	@GetMapping("/getPatientByNumber/{number}")
	public PatientEntity getPatientByNumber(@PathVariable String number) throws PatientException{
		return impl.getPatientByNumber(number);
	}
	
	@GetMapping("/getPatientByDoctorId/{id}")
	public PatientEntity getPatientByDoctorId(@PathVariable int id) throws PatientException{
		return impl.getPatientByDoctorId(id);
	}
	
	@PostMapping("/addPatient")
	public PatientEntity addPatient(@RequestBody PatientEntity patient) throws PatientException{
		return impl.addPatient(patient);
	}
	
	
	@PutMapping("/editPatient/{id}")
	public PatientEntity updatePatient(@PathVariable int id,@RequestBody PatientEntity patient) throws PatientException{
		return impl.updatePatient(id, patient);
	}
	
	
	@DeleteMapping("/remove/{id}")
	public void deletePatient(@PathVariable int id) {
		impl.deletePatient(id);
	}

}
