package com.serenity.hospital.ormcoursework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "receptionist")

public class Receptionist {
    @Id
    @Column(name = "receptionist_id")
    private String id;
    private String name;
    private String email;
    private String userName;
    private String password;
}
