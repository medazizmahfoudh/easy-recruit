package com.easyrecruit.interview.infra.payload;

import lombok.Data;
import java.util.List;

@Data
public class TopicWithQuestionsDTO {
    private String topic;
    private List<QuestionWithResponsesDTO> questions;
}
