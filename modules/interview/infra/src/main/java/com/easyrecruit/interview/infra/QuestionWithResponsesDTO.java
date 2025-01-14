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
public class QuestionWithResponsesDTO {
    private String topic;
    private String question;
    private List<String> responses;

}
