package com.easyrecruit.planification.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MongoEntity(collection = "availability")
public class AvailabilityEntity {
    @Id
    private String id;
    private String uuid;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
