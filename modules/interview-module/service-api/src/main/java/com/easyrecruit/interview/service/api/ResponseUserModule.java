package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.infra.Entity.ResponseUser;

import java.util.List;
public interface ResponseUserModule {
    void saveUserAnswers(List<ResponseUser> responsesUser);
    List<ResponseUser> getUserAnswersByCandidateId(Long candidateId);
}