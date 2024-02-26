package com.cg.doctor.controller;

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

import com.cg.doctor.entity.DoctorEntity;
import com.cg.doctor.exception.DoctorException;
import com.cg.doctor.service.DoctorServiceImpl;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorServiceImpl Impl;
	
	@GetMapping("/getAllDoctors")
	public List<DoctorEntity> getAllDoctors(){
		return Impl.getAllDoctors();
	}
	
	
	@GetMapping("/getDoctorById/{id}")
	public DoctorEntity getDoctorById(@PathVariable int id) throws DoctorException{
		return Impl.getDoctorById(id);
	}
	
	
	@GetMapping("/getDoctorByPatientId/{patientId}")
	public List<DoctorEntity> getDoctorByPatientId(@PathVariable int patientId) throws DoctorException{
		return Impl.getDoctorByPatientId(patientId);
	}
	
	@GetMapping("/getDoctorByMedicalId/{medicalId}")
	public List<DoctorEntity> getDoctorByMedicalId(@PathVariable int medicalId) throws DoctorException{
		return Impl.getDoctorByMedicalId(medicalId);
	}
	
	@PostMapping("/addDoctor")
	public DoctorEntity addDoctor(@RequestBody DoctorEntity addDoctor) {
		return Impl.addDoctor(addDoctor);
	}
	
	
	@PutMapping("/updateDoctor/{id}")
	public DoctorEntity updateDoctor(@PathVariable int id,@RequestBody DoctorEntity editDoctor) throws DoctorException{
		return Impl.updateDoctor(id, editDoctor);
	}
	
	
	@DeleteMapping("/deleteDoctor/{id}")
	public String deleteDoctor(@PathVariable int id) {
		Impl.deleteDoctor(id);
		return "successifully deleted";
	}

}
