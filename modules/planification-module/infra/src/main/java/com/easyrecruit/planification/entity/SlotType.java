package com.easyrecruit.planification.entity;

public enum SlotType {
    RECRUITER("Recruiter"),
    APPLICANT("Applicant");

    private String value;
    SlotType (String value) {
        this.value = value;
    }
}
