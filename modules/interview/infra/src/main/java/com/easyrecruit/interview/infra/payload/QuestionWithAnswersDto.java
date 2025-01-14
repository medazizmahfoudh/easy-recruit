package com.easyrecruit.interview.infra;

import com.easyrecruit.interview.dal.entity.Question;
import com.easyrecruit.interview.dal.entity.Reponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class QuestionWithAnswersDto {
    private Question question;
    private List<Reponse> reponses;

    private   String topic;
    // Constructeur avec les paramètres Question et List<Reponse>
    public QuestionWithAnswersDto(Question question, List<Reponse> reponses) {
        this.question = question;
        this.reponses = reponses;
    }

    // Getters et Setters
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }}



