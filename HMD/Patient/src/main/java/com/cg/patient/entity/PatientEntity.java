package com.cg.patient.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "patients")
public class PatientEntity {
	
	@Transient
    public static final String SEQUENCE_NAME="patient_sequence";
	@Id
	private int patientId;
	private String patientName;
	private String phoneNumber;
	private int age;
	private String description;
	private int doctorId;
	private boolean appointment;
	
	public PatientEntity(int patientId, String patientName, int age, String description, int doctorId) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.description = description;
        this.doctorId = doctorId;
        this.appointment = (doctorId != 0);
    }
	
	

}
