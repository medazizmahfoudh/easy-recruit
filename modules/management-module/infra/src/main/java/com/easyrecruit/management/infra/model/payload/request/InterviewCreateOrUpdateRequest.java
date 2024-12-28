package com.easyrecruit.management.infra.model.payload.request;

public record InterviewCreateOrUpdateRequest(String date, String location, String positionUuid, String recruiterUuid, String candidateUuid) {

}
