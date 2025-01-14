package com.easyrecruit.interview.infra.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TopicWithQuestionsDTO {
    private String topic;
    private List<QuestionWithResponsesDTO> questions;

    public TopicWithQuestionsDTO(String topic, List<QuestionWithResponsesDTO> questions) {
        this.topic = topic;
        this.questions = questions;
    }

    // Getters and setters
}
