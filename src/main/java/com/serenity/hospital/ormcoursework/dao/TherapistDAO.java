package com.serenity.hospital.ormcoursework.dao;

import com.serenity.hospital.ormcoursework.entity.Therapist;

import java.util.List;

public interface TherapistDAO extends CrudDAO<Therapist> {
    Therapist getById(String therapistId);

    List<Therapist> getAll();
}
