package com.serenity.hospital.ormcoursework.dao;

import com.serenity.hospital.ormcoursework.entity.Patient;

import java.util.List;

public interface PatientDAO extends CrudDAO<Patient> {
    Patient getById(String patientId);

//    boolean save(Patient entity);
//
//    boolean update(Patient entity);
//
//    boolean delete(String patientId);
//
//    String getNextId();

    List<Patient> getAll();
}
