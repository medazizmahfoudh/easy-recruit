package com.easyrecruit.management.infra.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.Set;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
public class Candidate {

    @JsonIgnore
    private String id;
    private String uuid = UUID.randomUUID().toString();
    private String firstname;
    private String lastname;
    private String email;
}
