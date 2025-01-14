package com.easyrecruit.interview.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionResponse {
    private int score;
    private int totalQuestions;
    private List<Long> correctAnswers;
}