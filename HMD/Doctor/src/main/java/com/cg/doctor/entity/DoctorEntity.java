package com.cg.doctor.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "doctor")
public class DoctorEntity {
	
	@Transient
    public static final String SEQUENCE_NAME="doctor_sequence";
	
	@Id
	private int doctorId;
	private String name;
	private String spacialization;
	private int medicalId;
	private int patientId;
	private boolean availability;

}
