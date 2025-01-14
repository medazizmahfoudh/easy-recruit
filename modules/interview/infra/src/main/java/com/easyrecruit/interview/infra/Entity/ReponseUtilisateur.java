package com.easyrecruit.interview.infra.Entity;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.dal.entity.ReponseEntity;
import com.easyrecruit.management.dal.entity.CandidateEntity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReponseUtilisateur {
    private Long id;

    @ManyToOne
    private CandidateEntity candidat;

    @ManyToOne
    private QuestionEntity question;

    @ManyToOne
    private ReponseEntity reponse;

    private boolean correct;





}
