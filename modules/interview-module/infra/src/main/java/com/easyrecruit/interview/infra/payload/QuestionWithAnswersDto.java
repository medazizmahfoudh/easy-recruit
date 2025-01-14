package com.easyrecruit.interview.infra.payload;

import com.easyrecruit.interview.infra.Entity.Question;
import com.easyrecruit.interview.infra.Entity.Response;
import lombok.Data;

import java.util.List;

@Data
public class QuestionWithAnswersDto {
    private Question question;
    private List<Response> responses;
    private String topic;

    public QuestionWithAnswersDto(Question question, List<Response> responses) {
        this.question = question;
        this.responses = responses;
    }


}
