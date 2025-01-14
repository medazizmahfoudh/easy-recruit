package com.easyrecruit.interview.dal.entity;


import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private CandidateEntity candidate;
    private int score;
    private String topic;

}
