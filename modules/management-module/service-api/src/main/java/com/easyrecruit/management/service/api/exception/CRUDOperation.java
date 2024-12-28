package com.easyrecruit.management.service.api.exception;

public enum CRUDOperation {
    CREATE("CREATE"),
    READ("READ"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    ;

    public final String label;

    private CRUDOperation(String label) {
        this.label = label;
    }
}
