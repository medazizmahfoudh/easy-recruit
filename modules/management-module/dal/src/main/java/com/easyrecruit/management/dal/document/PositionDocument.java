package com.easyrecruit.management.dal.document;

import com.easyrecruit.management.infra.model.entity.Skill;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@Document("Position")
public class PositionDocument {

    @Id
    private String id;
    private String uuid;
    private String name;
    private String description;
    private String location;
    private Set<Skill> requiredSkillSet;

}
