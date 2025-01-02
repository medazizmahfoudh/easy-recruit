package com.easyrecruit.service;

import com.easyrecruit.management.dal.entity.ApplicationEntity;
import com.easyrecruit.management.dal.repository.ApplicationRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@BrowserCallable
@AnonymousAllowed
public class ApplicationService{

    @Autowired
    private ApplicationRepository repository;


    public List<ApplicationEntity> findAll(){
        return repository.findAll();
    }
}
