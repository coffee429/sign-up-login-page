package com.blackhoodie.constant;

public enum ErrorEnum {
    ERR1("CANNOT_SIGN_UP"),
    ERR2("CANNOT_LOG_IN");

    private String error;

    ErrorEnum(String error) {
        this.error = error;
    }
}

