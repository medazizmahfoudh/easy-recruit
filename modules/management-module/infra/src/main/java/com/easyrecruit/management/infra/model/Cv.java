package com.easyrecruit.management.infra.model;

import com.easyrecruit.management.infra.model.entity.Skill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.Binary;

import java.util.List;
import java.util.UUID;

@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
public class Cv {
    private String uuid = UUID.randomUUID().toString();
    private String applicationUuid;
    private Binary document;
    private List<Skill> skills;
}
