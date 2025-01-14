package com.easyrecruit.interview.infra.Entity;

import com.easyrecruit.management.infra.model.entity.Candidate;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ResponseUser {
    private Long id;
    @ManyToOne
    private Candidate candidate;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Response response;
    private boolean correct;





}
