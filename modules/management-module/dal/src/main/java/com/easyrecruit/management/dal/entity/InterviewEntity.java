package com.easyrecruit.management.dal.entity;

import com.easyrecruit.management.dal.converter.UUIDConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@Table(
        name = "interview"
)
public class InterviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = UUIDConverter.class)
    @Column(columnDefinition = "varchar")
    private UUID uuid;
    private LocalDateTime date;
    private String location;
    private String positionUuid;
    @ManyToOne
    private RecruiterEntity recruiter;
    @ManyToOne
    private CandidateEntity candidate;
    @OneToOne
    private EvaluationEntity evaluation;



}
