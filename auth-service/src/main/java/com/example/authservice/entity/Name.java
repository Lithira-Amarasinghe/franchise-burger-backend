package com.example.authservice.entity;

import jakarta.persistence.*;

@Entity
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;

    @OneToOne
    private User user;
}
