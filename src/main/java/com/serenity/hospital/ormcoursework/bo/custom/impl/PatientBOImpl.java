package com.serenity.hospital.ormcoursework.bo.custom.impl;

import com.serenity.hospital.ormcoursework.bo.custom.PatientBO;
import com.serenity.hospital.ormcoursework.dao.PatientDAO;
import com.serenity.hospital.ormcoursework.dao.impl.PatientDAOImpl;
import com.serenity.hospital.ormcoursework.dto.PatientDTO;
import com.serenity.hospital.ormcoursework.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientBOImpl implements PatientBO {
    private final PatientDAO patientDAO = new PatientDAOImpl();

    @Override
    public boolean savePatient(PatientDTO patientDTO) {
        return patientDAO.save(
                new Patient(
                        patientDTO.getPatientID(),
                        patientDTO.getPatientName(),
                        patientDTO.getAge(),
                        patientDTO.getPhoneNumber(),
                        patientDTO.getGender(),
                        patientDTO.getAddress(),
                        patientDTO.getTherapyProgram()
                )
        );
    }

    @Override
    public boolean updatePatient(PatientDTO patientDTO) {
        return patientDAO.update(
                new Patient(
                        patientDTO.getPatientID(),
                        patientDTO.getPatientName(),
                        patientDTO.getAge(),
                        patientDTO.getPhoneNumber(),
                        patientDTO.getGender(),
                        patientDTO.getAddress(),
                        patientDTO.getTherapyProgram()
                )
        );
    }

    @Override
    public boolean deletePatient(String id) throws Exception {
        return patientDAO.delete(id);
    }

    @Override
    public List<PatientDTO> loadAllPatients() throws Exception {
        ArrayList<PatientDTO> patientDTOS = new ArrayList<>();
        List<Patient> patients = patientDAO.getAll();

        for (Patient patient : patients) {
            patientDTOS.add(
                    new PatientDTO(
                            patient.getPatientID(),
                            patient.getPatientName(),
                            patient.getAge(),
                            patient.getPhoneNumber(),
                            patient.getGender(),
                            patient.getAddress(),
                            patient.getTherapyProgram()
                    )
            );
        }
        return patientDTOS;
    }

    @Override
    public String getNextPatientID() {
        return patientDAO.getNextId();
    }

    @Override
    public List<String> getAllPatientNames() {
        ArrayList<String> patientNames = new ArrayList<>();
        List<Patient> patients = patientDAO.getAll();

        for (Patient patient : patients) {
            patientNames.add(patient.getPatientName());
        }
        return patientNames;
    }
}
