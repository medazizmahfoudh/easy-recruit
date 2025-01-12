package com.easyrecruit.management.dal.entity;

import com.easyrecruit.management.dal.converter.UUIDConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@Table(
        name = "recruiter"
)

public class RecruiterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = UUIDConverter.class)
    @Column(columnDefinition = "varchar")
    private UUID uuid;
    private String firstname;
    private String lastname;
    private String department;
    private String title;
}
