package com.easyrecruit.management.infra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
public class Interview {

    @JsonIgnore
    private String id;
    private String uuid = UUID.randomUUID().toString();
    private Date date;
    private String location;
    private String positionUuid;
    private Evaluation evaluation;
    private Recruiter recruiter;
    private Candidate candidate;
    private InterviewStatus status;
    private String comment;


}
