package com.serenity.hospital.ormcoursework.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TherapistTM {
    private String therapistID;
    private String therapistName;
    private String email;
    private String phoneNumber;
    private String specialization;
}
