package com.easyrecruit.management.dal.entity;

import com.easyrecruit.management.dal.converter.UUIDConverter;
import com.easyrecruit.management.infra.model.entity.ApplicationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

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
    @Convert(converter = UUIDConverter.class)
    @Column(columnDefinition = "varchar")
    private UUID uuid;
    private String cvUuid;
    private String positionUuid;
    @ManyToOne
    private CandidateEntity candidate;
    private ApplicationStatus status;


}
