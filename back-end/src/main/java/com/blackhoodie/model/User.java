package com.blackhoodie.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty
    private String name;

    @Column(name = "gender", nullable = false)
    @JsonProperty
    private Integer gender;

    @Column(name = "phone_number", nullable = false)
    @JsonProperty
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    @JsonProperty
    private String email;

    public User(String name, Integer gender, String phoneNumber, String email) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User() {
    }
}
