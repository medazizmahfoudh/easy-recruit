package com.easyrecruit.management.service.impl;

import com.easyrecruit.management.dal.document.CvDocument;
import com.easyrecruit.management.dal.repository.CvRepository;
import com.easyrecruit.management.infra.model.Cv;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.infra.model.payload.response.OperationStatus;
import com.easyrecruit.management.service.api.CvModule;
import com.easyrecruit.management.service.api.exception.CRUDOperation;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;
import com.easyrecruit.management.service.impl.converter.CvConverter;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class CvModuleImpl implements CvModule {

    @Autowired
    private CvRepository repository;


    @Override
    public void saveCv(Cv cv) {
        repository.save(CvConverter.INSTANCE.toEntity(cv));
    }

    @Override
    public Cv updateCv(String cvUuid, MultipartFile file) {
        Optional<CvDocument> cvDocument = repository.getCvDocumentByUuid(cvUuid);
        if (cvDocument.isEmpty()){
            throw new CRUDOperationException(CRUDOperation.READ, "Cv with the given uuid doesn't exit.");
        }
        Cv cv = CvConverter.INSTANCE.fromEntity(cvDocument.get());
        try {
            Binary fileBinary = new Binary(file.getBytes());
            cv.setDocument(fileBinary);
            repository.save(CvConverter.INSTANCE.toEntity(cv));
        } catch (IOException e) {
            throw new CRUDOperationException(CRUDOperation.CREATE, e.getMessage());
        }
        return cv;
    }

    @Override
    public Cv getCvByApplicationUuid(String applicationUuid) {
        Optional<CvDocument> cvDocument = repository.getCvDocumentByApplicationUuid(applicationUuid);
        if (cvDocument.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Cv for the given application doesn't exist.");
        }
        return CvConverter.INSTANCE.fromEntity(cvDocument.get());
    }

    @Override
    public Cv getCvByUuid(String uuid) {
        Optional<CvDocument> cvDocument = repository.getCvDocumentByUuid(uuid);
        if (cvDocument.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Cv for the given identifier doesn't exist.");
        }
        return CvConverter.INSTANCE.fromEntity(cvDocument.get());
    }

    @Override
    public List<Cv> getAllCvs() {
         return repository.findAll()
                 .stream()
                 .map(CvConverter.INSTANCE::fromEntity)
                 .toList();

    }

    @Override
    public DeleteResponse deleteCv(Cv cv) {
        repository.delete(CvConverter.INSTANCE.toEntity(cv));
        return new DeleteResponse(OperationStatus.SUCCESS, "Resource has been deleted.");

    }

    @Override
    public DeleteResponse deleteCvByApplicationUuid(String applicationUuid) {
        repository.deleteByApplicationUuid(applicationUuid);
        return new DeleteResponse(OperationStatus.SUCCESS, "Resource has been deleted.");
    }

    @Override
    public DeleteResponse deleteAll() {
        repository.deleteAll();
        return new DeleteResponse(OperationStatus.SUCCESS, "Resource has been deleted.");
    }
}
