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
@Table(name = "patient")

public class Patient {
    @Id
    @Column(name = "patient_id", nullable = false, length = 50)
    private String patientID;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private String Age;

    @Column(nullable = false)
    private String PhoneNumber;

    @Column(nullable = false)
    private String Gender;

    @Column(nullable = false)
    private String Address;

    @Column(nullable = false)
    private String TherapyProgram;
}
