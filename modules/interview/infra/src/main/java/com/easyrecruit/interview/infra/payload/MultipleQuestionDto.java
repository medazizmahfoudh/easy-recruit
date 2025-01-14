package com.easyrecruit.interview.infra;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class MultipleQuestionDto {
    private List<QuestionWithAnswersDto> questions; // Liste des questions et leurs réponses

}
