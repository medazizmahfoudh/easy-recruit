package com.easyrecruit.payloads;

import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.infra.model.entity.Skill;

import java.util.List;

public record TrainingResponse(
    String candidateName,
    Application application
) {
}
