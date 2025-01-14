package com.easyrecruit.interview.infra.payload;

import java.util.List;

public class SubmissionResponse {
    private int score;
    private int totalQuestions;
    private List<Long> correctAnswers;

    // Getters et setters

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public List<Long> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<Long> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
}