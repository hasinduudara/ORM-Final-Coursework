package com.serenity.hospital.ormcoursework.bo.custom.impl;

import com.serenity.hospital.ormcoursework.bo.custom.TherapyProgramBO;
import com.serenity.hospital.ormcoursework.dao.TherapyProgramDAO;
import com.serenity.hospital.ormcoursework.dto.TherapyProgramDTO;
import com.serenity.hospital.ormcoursework.entity.TherapyProgram;

import java.util.ArrayList;

public class TherapyProgramBoImpl implements TherapyProgramBO {

    private TherapyProgramDAO therapyProgramDAO;

    public TherapyProgramBoImpl() {
        this.therapyProgramDAO = therapyProgramDAO;
    }

    @Override
    public boolean addTherapyProgram(TherapyProgramDTO therapyProgramDTO) {
        return therapyProgramDAO.save(
                new TherapyProgram(therapyProgramDTO.getProgramID(),
                        therapyProgramDTO.getProgramName(),
                        therapyProgramDTO.getDescription(),
                        therapyProgramDTO.getDuration(),
                        therapyProgramDTO.getCost(),
                        therapyProgramDTO.getTherapistName()
                )
        );
    }

    @Override
    public boolean updateTherapyProgram(TherapyProgramDTO therapyProgramDTO) {
        return therapyProgramDAO.update(
                new TherapyProgram(therapyProgramDTO.getProgramID(),
                        therapyProgramDTO.getProgramName(),
                        therapyProgramDTO.getDescription(),
                        therapyProgramDTO.getDuration(),
                        therapyProgramDTO.getCost(),
                        therapyProgramDTO.getTherapistName()
                )
        );
    }

    @Override
    public boolean deleteTherapyProgram(int programId) throws Exception {
        return therapyProgramDAO.delete(String.valueOf(programId));
    }

    @Override
    public String getNextTherapyProgramID() {
        return therapyProgramDAO.getNextId();
    }

    @Override
    public ArrayList<TherapyProgramDTO> loadAllTherapyPrograms() throws Exception {
        ArrayList<TherapyProgramDTO> therapyProgramDTOS = new ArrayList<>();
        ArrayList<TherapyProgram> therapyPrograms = (ArrayList<TherapyProgram>) therapyProgramDAO.getAll();

        for (TherapyProgram therapyProgram : therapyPrograms) {
            therapyProgramDTOS.add(
                    new TherapyProgramDTO
                            (therapyProgram.getProgramID(),
                                    therapyProgram.getProgramName(),
                                    therapyProgram.getDescription(),
                                    therapyProgram.getDuration(),
                                    therapyProgram.getCost(),
                                    therapyProgram.getTherapistName()
                            ));
        }
        return therapyProgramDTOS;
    }
}
