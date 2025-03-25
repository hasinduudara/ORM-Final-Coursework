package com.serenity.hospital.ormcoursework.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminDTO {
    private String id;
    private String name;
    private String email;
    private String userName;
    private String password;
}
