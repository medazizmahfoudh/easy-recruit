package com.easyrecruit.interview.infra;

import java.util.List;

public class SubmitAnswersRequest {
    private List<ResponseInput> responses;

    public List<ResponseInput> getResponses() {
        return responses;
    }

    public void setResponses(List<ResponseInput> responses) {
        this.responses = responses;
    }
}
