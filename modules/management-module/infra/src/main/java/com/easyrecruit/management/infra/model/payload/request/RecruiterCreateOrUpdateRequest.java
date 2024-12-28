package com.easyrecruit.management.infra.model.payload.request;

public record RecruiterCreateOrUpdateRequest(String firstname, String lastname, String department, String title) {
}
