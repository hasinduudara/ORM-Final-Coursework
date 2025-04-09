package com.serenity.hospital.ormcoursework.dao;

import com.serenity.hospital.ormcoursework.entity.TherapyProgram;

import java.util.List;

public interface TherapyProgramDAO extends CrudDAO<TherapyProgram> {
    TherapyProgram getById(String therapyProgramId);

    TherapyProgram getByName(String therapyProgramName);

    void updateTherapyProgram(TherapyProgram therapyProgram);

    void deleteTherapyProgram(String therapyProgramId);

    List<TherapyProgram> getAll();
}
