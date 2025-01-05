package com.easyrecruit.management.dal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Entity
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@Table(
        name = "candidate"
)
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String firstname;
    private String lastname;
    private String email;
}
