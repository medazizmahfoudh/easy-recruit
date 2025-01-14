package com.easyrecruit.interview.dal.entity;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ResponseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CandidateEntity candidate;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Response response;
    private boolean correct;

}