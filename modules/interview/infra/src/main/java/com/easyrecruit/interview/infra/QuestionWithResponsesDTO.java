package com.easyrecruit.interview.infra;

import java.util.List;

public class QuestionWithResponsesDTO {
    private String topic;
    private String question;
    private List<String> responses;

    // Constructors
    public QuestionWithResponsesDTO() {}

    public QuestionWithResponsesDTO(String topic, String question, List<String> responses) {
        this.topic = topic;
        this.question = question;
        this.responses = responses;
    }

    // Getters and setters
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }
}
