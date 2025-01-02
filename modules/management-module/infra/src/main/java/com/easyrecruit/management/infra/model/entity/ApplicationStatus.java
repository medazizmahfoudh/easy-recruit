package com.easyrecruit.management.infra.model.entity;

public enum ApplicationStatus {
    NEW(0),
    PRELIMINARY(10),
    PRELIMINARY_REJECTED(9),
    PRELIMINARY_PASSED(11),
    INTERVIEW(20),
    INTERVIEW_REJECTED(19),
    INTERVIEW_PASSED(21),
    ACCEPTED(1),
    REJECTED(-1);

    private int value;
    ApplicationStatus(int value) {
        this.value = value;
    }
}
