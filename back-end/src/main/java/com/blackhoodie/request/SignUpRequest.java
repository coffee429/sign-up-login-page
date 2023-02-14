package com.blackhoodie.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignUpRequest {

    @JsonProperty
    private String name;

    @JsonProperty
    private Integer gender;

    @JsonProperty
    private String phoneNumber;

    @JsonProperty
    private String email;

    @JsonProperty
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
