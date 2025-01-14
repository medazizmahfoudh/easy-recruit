package com.easyrecruit.interview.dal.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(
        name = "Question"
)
@Entity
@NoArgsConstructor
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String correctAnswer;
    private String topic;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ResponseEntity> responses;
    @OneToMany(mappedBy = "question")
    private List<ResponseUserEntity> ListResponses;


    public QuestionEntity(Long id) {
        this.id = id;
    }
}
