package com.easyrecruit.planification.entity;

public enum OccupancyStatus {
    OCCUPIED("Occupied"),
    FREE("Free");

    private String label;
    OccupancyStatus(String label) {
        this.label = label;
    }

}
