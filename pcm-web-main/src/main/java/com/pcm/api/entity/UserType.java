package com.pcm.api.entity;

public enum UserType {
    P("Patient"),
    N("Nurse"),
    A("Admin"),
    SA("Super Admin");

    private final String displayName;

    UserType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
