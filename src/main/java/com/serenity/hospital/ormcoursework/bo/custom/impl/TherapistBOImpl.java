package com.serenity.hospital.ormcoursework.bo.custom.impl;

import com.serenity.hospital.ormcoursework.bo.custom.TherapistBO;
import com.serenity.hospital.ormcoursework.dao.TherapistDAO;
import com.serenity.hospital.ormcoursework.dao.impl.TherapistDAOImpl;
import com.serenity.hospital.ormcoursework.dto.TherapistDTO;
import com.serenity.hospital.ormcoursework.entity.Therapist;

import java.util.ArrayList;
import java.util.List;

public class TherapistBOImpl implements TherapistBO {
    private final TherapistDAO therapistDAO = new TherapistDAOImpl();

    @Override
    public boolean saveTherapist(TherapistDTO therapistDTO) {
        return therapistDTO.save(
                new Therapist(therapistDTO.getTherapistID(), therapistDTO.getTherapistName(),
                        therapistDTO.getEmail(), therapistDTO.getPhoneNumber(), therapistDTO.getSpecialization()
                )
        );
    }

    @Override
    public boolean updateTherapist(TherapistDTO therapistDTO) {
        return therapistDTO.update(
                new Therapist(therapistDTO.getTherapistID(), therapistDTO.getTherapistName(),
                        therapistDTO.getEmail(), therapistDTO.getPhoneNumber(), therapistDTO.getSpecialization()
                )
        );
    }

    @Override
    public boolean deleteTherapist(String id) throws Exception {
        return therapistDAO.delete(id);
    }

    @Override
    public List<TherapistDTO> loadAllTherapists() throws Exception {
        ArrayList<TherapistDTO> therapistDTOS = new ArrayList<>();
        ArrayList<Therapist> therapists = (ArrayList<Therapist>) therapistDAO.getAll();

        for (Therapist therapist : therapists) {
            therapistDTOS.add(
                    new TherapistDTO
                            (therapist.getTherapistID(), therapist.getTherapistName(), therapist.getEmail(), therapist.getPhoneNumber(), therapist.getSpecialization()
                    ));
        }
        return therapistDTOS;
    }

    @Override
    public String getNaxtTherapistID() {
        return therapistDAO.getNextId();
    }
}
