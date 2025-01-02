package com.easyrecruit.management.dal.entity;

import com.easyrecruit.management.infra.model.entity.ApplicationStatus;
import com.easyrecruit.management.infra.model.entity.Candidate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@Table(
        name = "application"
)
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String cvUuid;
    private String positionUuid;
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
    private ApplicationStatus status;


}
