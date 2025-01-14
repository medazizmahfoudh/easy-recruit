package com.easyrecruit.interview.infra.payload;

import com.easyrecruit.interview.dal.entity.ResponseEntity;
import com.easyrecruit.interview.infra.Entity.Question;
import lombok.Data;
import java.util.List;

@Data
public class QuestionWithAnswersDto {
    private Question question;
    private List<ResponseEntity> responses;
    private String topic;

    public QuestionWithAnswersDto(Question question, List<ResponseEntity> responses) {
        this.question = question;
        this.responses = responses;
    }


}
