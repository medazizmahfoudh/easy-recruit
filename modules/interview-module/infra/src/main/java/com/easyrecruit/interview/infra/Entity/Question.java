package com.easyrecruit.interview.infra.Entity;

import com.easyrecruit.interview.dal.entity.ResponseEntity;
import com.easyrecruit.interview.dal.entity.ResponseUserEntity;
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
    private List<ResponseEntity> responses;
    private List<ResponseUserEntity> ListResponses;

}
