package com.easyrecruit.interview.dal.entity;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table (name="Resultat" )
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private CandidateEntity candidate;
    private int score;
    private String topic;
    private int totalQuestions;
    private int correctQuestions;
}
