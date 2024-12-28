package com.easyrecruit.management.infra.model.payload.request;

import com.easyrecruit.management.infra.model.entity.Skill;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ApplicationSubmitOrUpdateRequest {

    @NotNull
    private String candidateUuid;
    @NotNull
    private String positionUuid;
    @NotNull
    private List<Skill> skills;

}