package com.easyrecruit.interview.infra.Entity;

import com.easyrecruit.interview.dal.entity.ReponseEntity;
import com.easyrecruit.interview.dal.entity.ReponseUtilisateurEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Question {
    private Long id;

    private String text;
    private String correctAnswer;
    private String topic; // Nouvel attribut pour le sujet de la question

    private List<ReponseEntity> responses;

    private List<ReponseUtilisateurEntity> ListResponses;
    // Getter et Setter
    public List<ReponseEntity> getResponses() {
        return responses;
    }



}
