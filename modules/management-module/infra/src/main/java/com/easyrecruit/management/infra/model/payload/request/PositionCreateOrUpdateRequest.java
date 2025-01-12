package com.easyrecruit.management.infra.model.payload.request;

import com.easyrecruit.management.infra.model.entity.Skill;

import java.util.List;

public record PositionCreateOrUpdateRequest(String name, String description, String location, List<Skill> skills) {
}
