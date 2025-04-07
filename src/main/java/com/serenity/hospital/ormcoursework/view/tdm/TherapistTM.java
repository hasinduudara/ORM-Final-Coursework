package com.serenity.hospital.ormcoursework.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TherapistTM {
    private String therapistID;
    private String therapistName;
    private String email;
    private String phoneNumber;
    private String specialization;
}
