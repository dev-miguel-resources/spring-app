package com.course.app_medic.models;

import jakarta.persistence.*;

@Entity
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatient;

    private String firstName;

    private String lastName;

    private String dni;

    private String address;

    private String phone;

    private String email;
}
