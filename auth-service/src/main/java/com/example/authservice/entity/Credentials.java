package com.example.authservice.entity;

import jakarta.persistence.*;

@Entity
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String username;
    private String password;

    @OneToOne
    private User user;
}
