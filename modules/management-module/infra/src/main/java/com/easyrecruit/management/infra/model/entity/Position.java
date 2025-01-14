package com.easyrecruit.management.infra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
public class Position {

    @JsonIgnore
    private String id;
    private String uuid = UUID.randomUUID().toString();
    private String name;
    private String description;
    private String location;
    private List<Skill> requiredSkills;
}
