package com.easyrecruit.interview.infra.payload;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.dal.entity.ReponseEntity;
import com.easyrecruit.interview.infra.Entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuestionWithAnswersDto {
    private Question question;
    private List<ReponseEntity> reponses;
    private String topic;

    // Constructeur avec les paramètres Question et List<Reponse>
    public QuestionWithAnswersDto(Question question, List<ReponseEntity> reponses) {
        this.question = question;
        this.reponses = reponses;
    }

    // Getter pour retourner l'ID de la question
    public Long getQuestionId() {
        if (this.question != null) {
            return this.question.getId(); // Assurez-vous que la méthode getId() existe dans QuestionEntity
        }
        return null; // ou une valeur par défaut si la question est nulle
    }

    // Getters et Setters
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question     question) {
        this.question = question;
    }

    public List<ReponseEntity> getReponses() {
        return reponses;
    }

    public void setReponses(List<ReponseEntity> reponses) {
        this.reponses = reponses;
    }
}
