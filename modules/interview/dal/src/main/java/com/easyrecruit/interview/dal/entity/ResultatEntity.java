package com.easyrecruit.interview.dal.entity;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table (name="Resultat" )
public class ResultatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference  // Empêche la sérialisation circulaire
    @ManyToOne  // Relation ManyToOne avec Candidate
    @JoinColumn(name = "candidate_id")  // Nom de la colonne pour la relation
    private CandidateEntity candidate;

    private int score;  // Le score du candidat

    private String topic;  // Le sujet du test

    private int totalQuestions;  // Nombre total de questions
    private int correctQuestions;  // Nombre de questions correctes

    // Constructeurs, getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCandidate(CandidateEntity CandidateEntity) {
        this.candidate = CandidateEntity;
    }



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
