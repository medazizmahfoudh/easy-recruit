package com.easyrecruit.management.infra.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
public class Evaluation {

    private Long id;
    private String uuid = UUID.randomUUID().toString();
    private String applicationUuid;
    private RecruitmentStep step = RecruitmentStep.PRELIMINARY;
    private Double score = 0.00 ;
    private String decision;
    private EvaluationStatus status = EvaluationStatus.IDLE;
    private String feedBack ;

}
