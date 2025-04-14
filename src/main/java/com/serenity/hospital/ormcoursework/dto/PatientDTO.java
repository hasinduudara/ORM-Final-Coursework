package com.serenity.hospital.ormcoursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PatientDTO {
    private String patientID;
    private String patientName;
    private String Age;
    private String PhoneNumber;
    private String Gender;
    private String Address;
    private String TherapyProgram;
}
