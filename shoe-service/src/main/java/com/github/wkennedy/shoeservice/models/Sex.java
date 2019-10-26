package com.github.wkennedy.shoeservice.models;

public enum Sex {
    MALE("M"),
    FEMALE("F");

    private String code;

    Sex(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
