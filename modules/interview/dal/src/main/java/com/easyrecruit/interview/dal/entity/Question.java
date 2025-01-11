package com.easyrecruit.interview.dal.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String correctAnswer;
    private String topic; // Nouvel attribut pour le sujet de la question

    public Question() {}

    public Question(Long id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Reponse> responses;

    @OneToMany(mappedBy = "question")
    private List<ReponseUtilisateur> ListResponses;
    // Getter et Setter
    public List<Reponse> getResponses() {
        return responses;
    }

    public void setResponses(List<Reponse> responses) {
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
