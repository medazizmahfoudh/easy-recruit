package com.easyrecruit.planification.entity;

import com.easyrecruit.management.infra.model.entity.Application;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {

    private String id;
    private String uuid;
    private LocalDateTime date;
    private OccupancyStatus status;
    private Application application;
    private SlotType type;

}
