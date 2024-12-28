package com.easyrecruit.management.infra.model.payload.request;

public record CandidateCreateOrUpdateRequest(String firstname, String lastname, String email) {
}
