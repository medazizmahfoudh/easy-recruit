package com.easyrecruit.management.service.api.exception;


public class CRUDOperationException extends RuntimeException{
    private final CRUDOperation crudOperation;
    private String message;

    public CRUDOperationException(CRUDOperation crudOperation, String message) {
        super(message);
        this.crudOperation = crudOperation;
    }

    public CRUDOperationException(CRUDOperation crudOperation, String message, Throwable th) {
        super(message, th);
        this.crudOperation = crudOperation;
    }

    public CRUDOperation getCrudOperation() {
        return crudOperation;
    }
}
