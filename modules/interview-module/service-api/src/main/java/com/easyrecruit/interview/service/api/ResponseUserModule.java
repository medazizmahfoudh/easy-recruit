package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.dal.entity.ResponseUserEntity;
import com.easyrecruit.interview.infra.Entity.ResponseUser;

import java.util.List;
public interface ResponseUserModule {
    void saveUserAnswers(List<ResponseUserEntity> reponsesUtilisateur);
    List<ResponseUser> getUserAnswersByCandidatId(Long candidatId);
}