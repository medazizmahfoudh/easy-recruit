package com.eniso.entities;

import com.easyrecruit.management.infra.model.entity.Skill;
import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Introspected
@Entity
public class ApplicationReport {

    @Id
    @GeneratedValue
    private Long id;
    private String uuid;
    @ElementCollection
    private List<Skill> missingSkills;
    @ElementCollection
    private Map<Skill, Integer> skillMap;
    private String applicationUUID;


    public ApplicationReport(Long id, String uuid, List<Skill> missingSkills, Map<Skill, Integer> skillMap, String applicationUUID) {
        this.id = id;
        this.uuid = uuid;
        this.missingSkills = missingSkills;
        this.skillMap = skillMap;
        this.applicationUUID = applicationUUID;
    }

    public ApplicationReport() {
    }

    private ApplicationReport(Builder builder) {
        setId(builder.id);
        setUuid(builder.uuid);
        setMissingSkills(builder.missingSkills);
        setSkillMap(builder.skillMap);
        setApplicationUUID(builder.applicationUUID);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<Skill> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<Skill> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public Map<Skill, Integer> getSkillMap() {
        return skillMap;
    }

    public void setSkillMap(Map<Skill, Integer> skillMap) {
        this.skillMap = skillMap;
    }

    public String getApplicationUUID() {
        return applicationUUID;
    }

    public void setApplicationUUID(String applicationUUID) {
        this.applicationUUID = applicationUUID;
    }

    public static final class Builder {
        private Long id;
        private String uuid;
        private List<Skill> missingSkills;
        private Map<Skill, Integer> skillMap;
        private String applicationUUID;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withUuid(String val) {
            uuid = val;
            return this;
        }

        public Builder withMissingSkills(List<Skill> val) {
            missingSkills = val;
            return this;
        }

        public Builder withSkillMap(Map<Skill, Integer> val) {
            skillMap = val;
            return this;
        }
        public Builder withApplicationUUID(String val) {
            applicationUUID = val;
            return this;
        }

        public ApplicationReport build() {
            return new ApplicationReport(this);
        }
    }
}
