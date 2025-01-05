package com.easyrecruit.planification.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;


@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Availabilitty {
    @JsonIgnore
    private String id;
    private String uuid = UUID.randomUUID().toString();
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
