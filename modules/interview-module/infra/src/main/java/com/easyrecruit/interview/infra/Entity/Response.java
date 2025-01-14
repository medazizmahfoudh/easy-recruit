package com.easyrecruit.interview.infra.Entity;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import lombok.Data;

@Data
public class Response {
    private Long id;
    private boolean correct;
    private String responseText;
    private QuestionEntity question;
}
