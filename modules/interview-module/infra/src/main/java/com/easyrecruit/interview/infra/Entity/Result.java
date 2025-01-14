package com.easyrecruit.interview.infra.Entity;

import com.easyrecruit.management.infra.model.entity.Candidate;
import lombok.Data;

@Data
public class Result {
    private Long id;
    private Candidate candidate;
    private int score;
    private String topic;
    private int totalQuestions;
    private int correctQuestions;
}
