package com.easyrecruit.interview.infra.payload;

import lombok.Data;

@Data
public class ResponseUserRequest {
    private int candidateId;
    private int questionId;
    private String givenAnswer;
}
