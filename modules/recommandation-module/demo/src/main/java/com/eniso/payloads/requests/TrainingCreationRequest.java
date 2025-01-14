package com.eniso.payloads.requests;

public class TrainingCreationRequest {

    private String topic;
    private String level;
    private String severity;
    private String trainerName;
    private String trainerEmail;
    private String trainerPhoneNumber;

    public TrainingCreationRequest(String topic, String level, String severity, String trainerName, String trainerEmail, String trainerPhoneNumber) {
        this.topic = topic;
        this.level = level;
        this.severity = severity;
        this.trainerName = trainerName;
        this.trainerEmail = trainerEmail;
        this.trainerPhoneNumber = trainerPhoneNumber;
    }

    public TrainingCreationRequest() {
    }

    public String getTopic() {
        return topic;
    }

    public String getLevel() {
        return level;
    }

    public String getSeverity() {
        return severity;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public String getTrainerEmail() {
        return trainerEmail;
    }

    public String getTrainerPhoneNumber() {
        return trainerPhoneNumber;
    }
}
