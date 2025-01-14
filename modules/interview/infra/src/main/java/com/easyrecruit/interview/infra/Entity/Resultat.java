package com.easyrecruit.interview.infra.Entity;

import com.easyrecruit.management.infra.model.entity.Candidate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Resultat {
    private Long id;

    private Candidate candidate;

    private int score;  // Le score du candidat

    private String topic;  // Le sujet du test

    private int totalQuestions;  // Nombre total de questions
    private int correctQuestions;
    // Constructeurs, getters et setters




}
