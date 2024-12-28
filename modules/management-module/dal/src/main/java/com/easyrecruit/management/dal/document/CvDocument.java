package com.easyrecruit.management.dal.document;

import com.easyrecruit.management.infra.model.entity.Skill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Accessors(chain = true)
@Document("CV")
@Getter
@Setter
@NoArgsConstructor
public class CvDocument {

    @Id
    private String id;
    private String uuid;
    private String applicationUuid;
    private Binary document;
    private List<Skill> skills;
}
