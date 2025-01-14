package com.easyrecruit.interview.dal.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "Response"
)
@Data
public class ResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean correct;
    private String responseText;
    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private QuestionEntity question;
}
