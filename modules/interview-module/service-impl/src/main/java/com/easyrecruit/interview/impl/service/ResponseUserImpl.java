package com.easyrecruit.interview.impl.service;

import com.easyrecruit.interview.dal.entity.ResponseUserEntity;
import com.easyrecruit.interview.dal.repository.ResponseUserRepository;
import com.easyrecruit.interview.impl.converter.ResponseUserConverter;
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
    public void saveUserAnswers(List<ResponseUser> responsesUser) {
        List<ResponseUserEntity> responseUserEntities = responsesUser.stream()
                .map(ResponseUserConverter.INSTANCE::toEntity)
                .toList();
        responseUserRepository.saveAll(responseUserEntities);
    }
    @Override
    public List<ResponseUser> getUserAnswersByCandidateId(Long candidateId) {
        return responseUserRepository.findByCandidateId(candidateId).stream()
                .map(ResponseUserConverter.INSTANCE::fromEntity)
                .toList();
    }


}
