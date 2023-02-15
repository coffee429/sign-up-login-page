package com.blackhoodie.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public Account() {
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
