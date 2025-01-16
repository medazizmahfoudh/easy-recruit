package com.easyrecruit.management.infra.model.payload.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InterviewCreateOrUpdateRequest {
    String date;
    String location;
    String positionUuid;
    String recruiterUuid;
    String candidateUuid;
}
