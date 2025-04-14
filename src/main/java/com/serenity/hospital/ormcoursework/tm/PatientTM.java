package com.serenity.hospital.ormcoursework.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PatientTM {
    private String patientID;
    private String patientName;
    private String Age;
    private String PhoneNumber;
    private String Gender;
    private String Address;
    private String TherapyProgram;
}
