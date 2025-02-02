package com.easyrecruit.management.infra.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Skill {
    private String name;
    private Integer level;
}
