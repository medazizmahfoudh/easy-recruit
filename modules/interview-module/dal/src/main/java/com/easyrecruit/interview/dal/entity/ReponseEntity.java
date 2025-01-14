package com.easyrecruit.interview.dal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(
        name = "Reponse"
)
public class ReponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean correct; // Ajout du champ 'correct' pour marquer si la réponse est correcte
    private String reponseText; // Le texte de la réponse

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private QuestionEntity question;  // Cette propriété doit exister pour la relation bidirectionnelle

    // Constructeur par défaut
    public ReponseEntity() {
    }

    // Constructeur avec id et texte de la réponse
    public ReponseEntity(Long id, String reponseText) {
        this.id = id;
        this.reponseText = reponseText;
    }

    // Constructeur avec uniquement le texte de la réponse
    public ReponseEntity(String reponseText) {
        this.reponseText = reponseText;
    }

    // Getter et Setter pour la propriété `question`
    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    // Getters et setters pour les autres propriétés
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReponseText() {
        return reponseText;
    }

    public void setReponseText(String reponseText) {
        this.reponseText = reponseText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
