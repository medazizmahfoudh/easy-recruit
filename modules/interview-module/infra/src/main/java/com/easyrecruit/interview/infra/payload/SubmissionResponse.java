package com.easyrecruit.interview.infra.payload;

import lombok.Data;
import java.util.List;

@Data
public class SubmissionResponse {
    private int score;
    private int totalQuestions;
    private List<Long> correctAnswers;
}