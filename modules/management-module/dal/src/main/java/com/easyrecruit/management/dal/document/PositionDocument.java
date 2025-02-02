package com.easyrecruit.management.dal.document;

import com.easyrecruit.management.infra.model.entity.Skill;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
public class PositionDocument {

    @Id
    private String id;
    private String uuid;
    private String name;
    private String description;
    private String location;
    private List<Skill> requiredSkills;

}
