package com.eniso.entities;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class Training {

    @Id
    @GeneratedValue
    private Integer id;
    private TrainingLevel level;
    private TrainingSeverity severity;
    private String topic;
    @Embedded
    private TrainerContact trainerContact;

    public Training() {
    }

    public Training(Integer id, TrainingLevel level, TrainingSeverity severity, String topic, TrainerContact trainerContact) {
        this.id = id;
        this.level = level;
        this.severity = severity;
        this.topic = topic;
        this.trainerContact = trainerContact;
    }

    private Training(Builder builder) {
        setId(builder.id);
        setLevel(builder.level);
        setSeverity(builder.severity);
        setTopic(builder.topic);
        setTrainerContact(builder.trainerContact);
    }

    public static Builder builder(Training copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.level = copy.getLevel();
        builder.severity = copy.getSeverity();
        builder.topic = copy.getTopic();
        builder.trainerContact = copy.getTrainerContact();
        return builder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrainingLevel getLevel() {
        return level;
    }

    public void setLevel(TrainingLevel level) {
        this.level = level;
    }

    public TrainingSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(TrainingSeverity severity) {
        this.severity = severity;
    }

    public TrainerContact getTrainerContact() {
        return trainerContact;
    }

    public void setTrainerContact(TrainerContact trainerContact) {
        this.trainerContact = trainerContact;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public static final class Builder {
        private Integer id;
        private TrainingLevel level;
        private TrainingSeverity severity;
        private String topic;
        private TrainerContact trainerContact;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withId(Integer val) {
            id = val;
            return this;
        }

        public Builder withLevel(TrainingLevel val) {
            level = val;
            return this;
        }

        public Builder withSeverity(TrainingSeverity val) {
            severity = val;
            return this;
        }

        public Builder withTopic(String val) {
            topic = val;
            return this;
        }

        public Builder withTrainerContact(TrainerContact val) {
            trainerContact = val;
            return this;
        }

        public Training build() {
            return new Training(this);
        }
    }
}
