package com.serenity.hospital.ormcoursework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "therapy_program")

public class TherapyProgram {
    @Id
    @Column(name = "program_id", nullable = false, length = 50)
    private String programID;

    @Column(nullable = false)
    private String programName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private String therapistName;
}
