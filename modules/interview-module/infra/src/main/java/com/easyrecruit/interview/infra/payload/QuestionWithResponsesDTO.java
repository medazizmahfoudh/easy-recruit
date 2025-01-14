package com.easyrecruit.interview.infra.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionWithResponsesDTO {

    private String topic;
    private String question;
    private List<String> responses;
}
