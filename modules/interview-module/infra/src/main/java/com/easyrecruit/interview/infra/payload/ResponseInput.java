package com.easyrecruit.interview.infra.payload;

import lombok.Data;

@Data
public class ResponseInput {
    private Long questionId;
    private String selectedAnswer;
}