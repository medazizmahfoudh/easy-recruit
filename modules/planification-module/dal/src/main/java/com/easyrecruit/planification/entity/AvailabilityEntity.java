package com.easyrecruit.planification.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "availability")
public class AvailabilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String uuid;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
