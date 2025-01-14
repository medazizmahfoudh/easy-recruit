package com.easyrecruit.interview.infra.payload;

import lombok.Data;
import java.util.List;

@Data
public class MultipleQuestionDto {
    private List<QuestionWithAnswersDto> questions;
}
