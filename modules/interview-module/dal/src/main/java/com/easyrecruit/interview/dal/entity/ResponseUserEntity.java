package com.easyrecruit.interview.dal.entity;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(
        name = "ResponseUser"
)
public class ResponseUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CandidateEntity candidate;
    @ManyToOne
    private QuestionEntity question;
    @ManyToOne
    private ResponseEntity response;
    private boolean correct;




}
