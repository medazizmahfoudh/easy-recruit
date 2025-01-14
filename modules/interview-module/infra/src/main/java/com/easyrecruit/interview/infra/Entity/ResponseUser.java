package com.easyrecruit.interview.infra.Entity;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.dal.entity.ResponseEntity;
import com.easyrecruit.management.dal.entity.CandidateEntity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ResponseUser {
    private Long id;
    @ManyToOne
    private CandidateEntity candidate;
    @ManyToOne
    private QuestionEntity question;
    @ManyToOne
    private ResponseEntity response;
    private boolean correct;





}
