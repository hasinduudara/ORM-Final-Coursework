package com.serenity.hospital.ormcoursework.dao;

import com.serenity.hospital.ormcoursework.entity.Patient;

import java.util.List;

public interface PatientDAO extends CrudDAO<Patient> {
    Patient getById(String patientId);

    List<Patient> getAll();
}
