package com.eniso.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Embeddable
public class TrainerContact {

    private String trainerName;
    private String trainerPhoneNumber;
    private String trainerEmail;

    public TrainerContact(String trainerName, String trainerPhoneNumber, String trainerEmail) {
        this.trainerName = trainerName;
        this.trainerPhoneNumber = trainerPhoneNumber;
        this.trainerEmail = trainerEmail;
    }

    public TrainerContact() {
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerPhoneNumber() {
        return trainerPhoneNumber;
    }

    public void setTrainerPhoneNumber(String trainerPhoneNumber) {
        this.trainerPhoneNumber = trainerPhoneNumber;
    }

    public String getTrainerEmail() {
        return trainerEmail;
    }

    public void setTrainerEmail(String trainerEmail) {
        this.trainerEmail = trainerEmail;
    }
}
