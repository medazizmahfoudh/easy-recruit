package com.easyrecruit.interview.infra.Entity;

import lombok.Data;

@Data
public class Response {
    private Long id;
    private boolean correct;
    private String responseText;
    private Question question;
}
