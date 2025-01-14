package com.easyrecruit.interview.impl.service;

import com.easyrecruit.interview.dal.entity.ResponseUserEntity;
import com.easyrecruit.interview.dal.repository.ResponseUserRepository;
import com.easyrecruit.interview.infra.Entity.ResponseUser;
import com.easyrecruit.interview.service.api.ResponseUserModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ResponseUserImpl implements ResponseUserModule {
    private final ResponseUserRepository responseUserRepository;

    @Autowired
    public ResponseUserImpl(ResponseUserRepository responseUserRepository) {
        this.responseUserRepository = responseUserRepository;
    }
    @Override
    public void saveUserAnswers(List<ResponseUserEntity> responsesUser) {
        responseUserRepository.saveAll(responsesUser);
    }
    @Override
    public List<ResponseUser> getUserAnswersByCandidatId(Long candidateId) {
        return responseUserRepository.findByCandidatId(candidateId).stream()
                .map(responseEntity -> {
                    ResponseUser responseUser = new ResponseUser();
                    responseUser.setResponse(responseEntity.getResponse());
                    responseUser.setCandidate(responseEntity.getCandidate());
                    responseUser.setQuestion(responseEntity.getQuestion());
                    responseUser.setCorrect(responseEntity.isCorrect());
                    return responseUser;
                })
                .toList();
    }


}
