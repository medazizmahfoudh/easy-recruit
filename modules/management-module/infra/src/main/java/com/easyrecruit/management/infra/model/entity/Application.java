package com.easyrecruit.management.infra.model.entity;

import com.easyrecruit.management.infra.model.Cv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
public class Application {

    @JsonIgnore
    private Long id;
    private String uuid = UUID.randomUUID().toString();
    private ApplicationStatus status = ApplicationStatus.NEW;
    private Candidate candidate;
    private Position position;
    private Cv cv;
}
