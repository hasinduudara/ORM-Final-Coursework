package com.serenity.hospital.ormcoursework.bo.custom;

import com.serenity.hospital.ormcoursework.dto.TherapistDTO;

public interface TherapistBO {

    boolean saveTherapist(TherapistDTO therapistDTO);

    boolean updateTherapist(TherapistDTO therapistDTO);

    boolean deleteTherapist(String id) throws Exception;

    java.util.List<TherapistDTO> loadAllTherapists() throws Exception;

    String getNaxtTherapistID();
}
