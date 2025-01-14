package com.easyrecruit.interview.dal.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
@Table(
        name = "Question"
)
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String correctAnswer;
    private String topic; // Nouvel attribut pour le sujet de la question

    public QuestionEntity() {}

    public QuestionEntity(Long id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ReponseEntity> responses;

    @OneToMany(mappedBy = "question")
    private List<ReponseUtilisateurEntity> ListResponses;
    // Getter et Setter
    public List<ReponseEntity> getResponses() {
        return responses;
    }

    public void setResponses(List<ReponseEntity> responses) {
        this.responses = responses;
    }
    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
