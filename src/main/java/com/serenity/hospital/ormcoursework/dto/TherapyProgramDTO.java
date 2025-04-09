package com.serenity.hospital.ormcoursework.dto;

import com.serenity.hospital.ormcoursework.entity.TherapyProgram;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TherapyProgramDTO {
    private String programID;
    private String programName;
    private String description;
    private int duration;
    private double cost;
    private String therapistName;

}
