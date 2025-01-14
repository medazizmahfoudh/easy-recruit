package com.easyrecruit.interview.infra.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Question {
    private Long id;
    private String text;
    private String correctAnswer;
    private String topic;
    private List<Response> responses;
    private List<ResponseUser> ListResponses;

}
