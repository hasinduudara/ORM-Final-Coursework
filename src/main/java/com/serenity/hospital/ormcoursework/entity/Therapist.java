package com.serenity.hospital.ormcoursework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "therapist")

public class Therapist {
    @Id
    @Column(name = "therapist_id", nullable = false, length = 50)
    private String therapistID;

    @Column(nullable = false)
    private String therapistName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String specialization;

//    @OneToMany(mappedBy = "therapist", cascade = CascadeType.ALL)
//    private List<TherapyProgram> therapistPrograms;
//
//    @OneToMany(mappedBy = "therapist", cascade = CascadeType.ALL)
//    private List<TherapySession> therapySessions;

}
