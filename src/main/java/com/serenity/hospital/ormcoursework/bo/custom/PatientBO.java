package com.serenity.hospital.ormcoursework.bo.custom;

import com.serenity.hospital.ormcoursework.dto.PatientDTO;

import java.util.List;

public interface PatientBO {

    boolean savePatient(PatientDTO patientDTO);

    boolean updatePatient(PatientDTO patientDTO);

    boolean deletePatient(String id) throws Exception;

    java.util.List<PatientDTO> loadAllPatients() throws Exception;

    String getNextPatientID();

    List<String> getAllPatientNames();
}
