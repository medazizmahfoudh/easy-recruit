package com.easyrecruit.interview.infra;

import com.easyrecruit.interview.dal.entity.Question;
import com.easyrecruit.interview.dal.entity.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWithAnswersDto {

    private Question question;
    private List<Response> repons;
    private String topic;

}



