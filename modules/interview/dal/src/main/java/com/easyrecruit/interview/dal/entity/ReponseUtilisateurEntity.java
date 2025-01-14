package com.easyrecruit.interview.dal.entity;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.infra.model.entity.Candidate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(
        name = "ReponseUtilisateur"
)
public class ReponseUtilisateurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CandidateEntity candidat;

    @ManyToOne
    private QuestionEntity question;

    @ManyToOne
    private ReponseEntity reponse;

    private boolean correct;




}
