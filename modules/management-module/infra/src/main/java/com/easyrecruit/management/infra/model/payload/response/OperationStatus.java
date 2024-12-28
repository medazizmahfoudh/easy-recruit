package com.easyrecruit.management.infra.model.payload.response;

public enum OperationStatus {
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE");

    private String label;

    OperationStatus(String label) {
        this.label = label;
    }
}
