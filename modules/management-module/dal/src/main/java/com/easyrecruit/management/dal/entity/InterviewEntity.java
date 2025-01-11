package com.easyrecruit.management.dal.entity;

import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.infra.model.entity.Evaluation;
import com.easyrecruit.management.infra.model.entity.Recruiter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Date;

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
    private String uuid;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String location;
    private String positionUuid;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "recruiter_id")),
            @AttributeOverride(name = "firstname", column = @Column(name = "recruiter_firstname")),
            @AttributeOverride(name = "lastname", column = @Column(name = "recruiter_lastname")),
            @AttributeOverride(name = "department", column = @Column(name = "recruiter_department")),
            @AttributeOverride(name = "title", column = @Column(name = "recruiter_title")),
            @AttributeOverride(name = "uuid", column = @Column(name = "recruiter_uuid"))}

    )


    private Recruiter recruiter;


    @Embedded

    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "candidate_id")),
            @AttributeOverride(name = "uuid", column = @Column(name = "candidate_uuid")),
            @AttributeOverride(name = "firstname", column = @Column(name = "candidate_firstname")),
            @AttributeOverride(name = "lastname", column = @Column(name = "candidate_lastname")),
            @AttributeOverride(name = "email", column = @Column(name = "candidate_email")),
            @AttributeOverride(name = "cv", column = @Column(name = "candidate_cv")),
    })
    private Candidate candidate;


}
