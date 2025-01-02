package com.easyrecruit.management.infra.model.entity;

public enum EvaluationStatus {
    IDLE("Idle"),
    COMPLETED("Completed");

    private String status;
    EvaluationStatus(String status) {
        this.status = status;
    }
}
