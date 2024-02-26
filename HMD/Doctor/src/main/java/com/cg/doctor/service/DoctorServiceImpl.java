package com.cg.doctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.doctor.entity.DoctorEntity;
import com.cg.doctor.exception.DoctorException;
import com.cg.doctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepository Repo;
	
	@Autowired
	SequenceGeneratorService sequence;

	@Override
	public List<DoctorEntity> getAllDoctors() {
		List<DoctorEntity> doctorList = Repo.findAll();
		return doctorList;
	}

	@Override
	public DoctorEntity getDoctorById(int id) throws DoctorException {
		
		Optional<DoctorEntity> getDoctor = Repo.findById(id);
		if(getDoctor.isPresent()) {
			DoctorEntity doctor = getDoctor.get();
			return doctor;
		}
		
		
		throw new DoctorException("id not found");
	}

	@Override
	public DoctorEntity addDoctor(DoctorEntity addDoctor) {
		addDoctor.setDoctorId(sequence.getSequenceNumber(DoctorEntity.SEQUENCE_NAME));
		
		return Repo.save(addDoctor);
	}

	@Override
	public DoctorEntity updateDoctor(int id, DoctorEntity editDoctor) throws DoctorException {
		
		DoctorEntity updateDoctor = Repo.findById(id).orElseThrow(()->new DoctorException("id not found"));
		updateDoctor.setName(editDoctor.getName());
		updateDoctor.setSpacialization(editDoctor.getSpacialization());

		
		return Repo.save(updateDoctor);
	}

	@Override
	public void deleteDoctor(int id) {
		Repo.deleteById(id);
		
	}

	@Override
	public List<DoctorEntity> getDoctorByPatientId(int patientId) throws DoctorException {
		List<DoctorEntity> doc = Repo.findAll();
		List<DoctorEntity> doctor = new ArrayList<>();
		for(DoctorEntity doctorList:doc) {
			if(doctorList.getPatientId()==patientId) {
				doctor.add(doctorList);
			}
		}
		if (!doctor.isEmpty()) {
	        return doctor;
	    } else {
	        throw new DoctorException("Data Not Found");
	    }
	}

	@Override
	public List<DoctorEntity> getDoctorByMedicalId(int medicalId) throws DoctorException {
		List<DoctorEntity> doc = Repo.findAll();
		
		List<DoctorEntity> doctor = new ArrayList<>();
		for(DoctorEntity doctorList:doc) {
			if(doctorList.getMedicalId()==medicalId) {
				doctor.add(doctorList);
				
			}
		}
		if (!doctor.isEmpty()) {
	        return doctor;
	    } else {
	        throw new DoctorException("Data Not Found");
	    }
	}

}
