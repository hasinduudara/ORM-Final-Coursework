package com.serenity.hospital.ormcoursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TherapistDTO {
    private String therapistID;
    private String therapistName;
    private String email;
    private int phoneNumber;
    private String specialization;
}
