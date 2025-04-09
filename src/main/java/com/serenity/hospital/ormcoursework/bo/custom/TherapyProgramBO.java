package com.serenity.hospital.ormcoursework.bo.custom;

import com.serenity.hospital.ormcoursework.dto.TherapyProgramDTO;

import java.util.ArrayList;

public interface TherapyProgramBO {

    boolean addTherapyProgram(TherapyProgramDTO therapyProgramDTO);

    boolean updateTherapyProgram(TherapyProgramDTO therapyProgramDTO);

    boolean deleteTherapyProgram(int programId) throws Exception;

    String getNextTherapyProgramID();

    ArrayList<TherapyProgramDTO> loadAllTherapyPrograms() throws Exception;
}
