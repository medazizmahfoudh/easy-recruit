package com.easyrecruit.management.infra.model.entity;

public enum InterviewStatus {
    SCHEDULED("Scheduled"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled");

    private String status;

    InterviewStatus(String status) {
        this.status = status;
    }
}
