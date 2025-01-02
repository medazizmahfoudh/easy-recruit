package com.easyrecruit.management.infra.model.entity;

public enum RecruitmentStep {
    PRELIMINARY("Preliminary"),
    INTERVIEW("Interview");

    private String value;
    RecruitmentStep(String value) {
        this.value = value;
    }
}
