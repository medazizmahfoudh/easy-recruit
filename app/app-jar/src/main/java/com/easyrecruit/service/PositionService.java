package com.easyrecruit.service;

import com.easyrecruit.management.dal.document.PositionDocument;
import com.easyrecruit.management.dal.repository.PositionRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@BrowserCallable
@AnonymousAllowed
public class PositionService {

    @Autowired
    private PositionRepository repository;

    public List<PositionDocument> findAll(){
        return repository.findAll();
    }
}
