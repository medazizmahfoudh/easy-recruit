package com.easyrecruit.interview.infra;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReponseUtilisateurRequest {
    private int candidateId;
    private int questionId;
    private String givenAnswer;

}
