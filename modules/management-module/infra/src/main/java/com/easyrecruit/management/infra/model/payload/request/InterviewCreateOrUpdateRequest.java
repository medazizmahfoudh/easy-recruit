package com.easyrecruit.management.infra.model.payload.request;


import org.springframework.lang.NonNull;

public record InterviewCreateOrUpdateRequest(@NonNull String date, @NonNull String location, @NonNull String positionUuid, @NonNull String recruiterUuid, @NonNull String candidateUuid) {

}
