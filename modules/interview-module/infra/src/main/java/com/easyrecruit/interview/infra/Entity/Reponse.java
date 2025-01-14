package com.easyrecruit.interview.infra.Entity;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

public class Reponse {
    private Long id;

    private boolean correct; // Ajout du champ 'correct' pour marquer si la réponse est correcte
    private String reponseText; // Le texte de la réponse

    private QuestionEntity question;  // Cette propriété doit exister pour la relation bidirectionnelle

    // Constructeur par défaut
    public Reponse() {
    }



}
