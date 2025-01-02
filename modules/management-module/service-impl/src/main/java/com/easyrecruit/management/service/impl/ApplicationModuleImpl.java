package com.easyrecruit.management.service.impl;

import com.easyrecruit.management.dal.entity.ApplicationEntity;
import com.easyrecruit.management.dal.repository.ApplicationRepository;
import com.easyrecruit.management.infra.model.Cv;
import com.easyrecruit.management.infra.model.entity.*;
import com.easyrecruit.management.infra.model.payload.request.ApplicationSubmitOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.infra.model.payload.response.OperationStatus;
import com.easyrecruit.management.service.api.*;
import com.easyrecruit.management.service.api.exception.CRUDOperation;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;
import com.easyrecruit.management.service.impl.converter.ApplicationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationModuleImpl implements ApplicationModule{

    @Autowired
    private ApplicationRepository repository;
    @Autowired
    private PositionModule positionModule;
    @Autowired
    private CandidateModule candidateModule;
    @Autowired
    private CvModule cvModule;
    @Autowired
    private EvaluationModule evaluationModule;


    @Override
    public Application createApplication(ApplicationSubmitOrUpdateRequest request) throws CRUDOperationException {

        if (repository.existsByCandidate_UuidAndPositionUuid(request.getCandidateUuid(), request.getPositionUuid())) {
            throw new CRUDOperationException(CRUDOperation.CREATE, "Application for the given candidate (uuid) and position (uuid) already exists");
        }

        Position position = positionModule.getPositionByUuid(request.getPositionUuid());
        Candidate candidate = candidateModule.getCandidateByUuid(request.getCandidateUuid());

        Cv cv = new Cv()
                .setSkills(request.getSkills());
        Application application = new Application()
                .setCandidate(candidate)
                .setPosition(position);
        cv.setApplicationUuid(application.getUuid());
        application.setCv(cv);

        repository.save(ApplicationConverter.INSTANCE.toEntity(application));
        cvModule.saveCv(cv);

        Evaluation evaluation = new Evaluation().setApplicationUuid(application.getUuid());
        evaluationModule.createEvaluation(evaluation);

        return application;
    }

    @Override
    public Application getApplicationByUuid(String uuid) throws CRUDOperationException {
        Optional<ApplicationEntity> applicationEntity = repository.getApplicationEntityByUuid(uuid);
        if (applicationEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Application not found for the given uuid.");
        }
        Application application = ApplicationConverter.INSTANCE.fromEntity(applicationEntity.get());
        Cv cv = cvModule.getCvByApplicationUuid(application.getUuid());
        application.setCv(cv);
        return application;
    }

    @Override
    public Application updateApplicationStatus(String applicationUuid, Integer applicationStatus) throws CRUDOperationException {
        Optional<ApplicationEntity> applicationEntity = repository.getApplicationEntityByUuid(applicationUuid);
        if (applicationEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Application not found for the given uuid.");
        }
        Application application = ApplicationConverter.INSTANCE.fromEntity(applicationEntity.get());

        switch (applicationStatus) {
            case -1 : application.setStatus(ApplicationStatus.REJECTED);
            case 0 : application.setStatus(ApplicationStatus.NEW);
            case 1 : application.setStatus(ApplicationStatus.ACCEPTED);
            case 9 : application.setStatus(ApplicationStatus.PRELIMINARY_REJECTED);
            case 10 : application.setStatus(ApplicationStatus.PRELIMINARY);
            case 11 : application.setStatus(ApplicationStatus.PRELIMINARY_PASSED);
            case 19 : application.setStatus(ApplicationStatus.INTERVIEW_REJECTED);
            case 20 : application.setStatus(ApplicationStatus.INTERVIEW);
            case 21 : application.setStatus(ApplicationStatus.INTERVIEW_PASSED);
        }

        repository.save(ApplicationConverter.INSTANCE.toEntity(application));

        return application;
    }

    @Override
    public Application getApplicationByCandidateUuidAndPositionUuid(String candidateUuid, String positionUuid) throws CRUDOperationException {
        Optional<ApplicationEntity> applicationEntity = repository.getApplicationEntityByCandidate_UuidAndPositionUuid(candidateUuid, positionUuid);
        if (applicationEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Application not found for the given candidate uuid and position uuid.");
        }
        Application application = ApplicationConverter.INSTANCE.fromEntity(applicationEntity.get());
        Cv cv = cvModule.getCvByApplicationUuid(application.getUuid());
        application.setCv(cv);
        return application;
    }

    @Override
    public List<Application> getApplicationsByCandidateFirstname(String firstname) throws CRUDOperationException {
        List<ApplicationEntity> applicationEntities = repository.getApplicationEntitiesByCandidate_Firstname(firstname);
        return  applicationEntities.stream()
                .map(ApplicationConverter.INSTANCE::fromEntity)
                .peek(application -> {
                    Cv cv = cvModule.getCvByApplicationUuid(application.getUuid());
                    application.setCv(cv);
                })
                .toList();
    }

    @Override
    public List<Application> getApplicationsByCandidateLastname(String lastname) throws CRUDOperationException {
        List<ApplicationEntity> applicationEntities = repository.getApplicationEntitiesByCandidate_Lastname(lastname);
        return  applicationEntities.stream()
                .map(ApplicationConverter.INSTANCE::fromEntity)
                .peek(application -> {
                    Cv cv = cvModule.getCvByApplicationUuid(application.getUuid());
                    application.setCv(cv);
                })
                .toList();
    }

    @Override
    public List<Application> getApplicationsByCandidateFullname(String fullname) throws CRUDOperationException {
        List<String> name = Arrays.stream(fullname.split(" ")).toList();
        List<ApplicationEntity> applicationEntities = repository.getApplicationEntitiesByCandidate_FirstnameAndCandidate_Lastname(name.get(0), name.get(1));
        return  applicationEntities.stream()
                .map(ApplicationConverter.INSTANCE::fromEntity)
                .peek(application -> {
                    Cv cv = cvModule.getCvByApplicationUuid(application.getUuid());
                    application.setCv(cv);
                })
                .toList();
    }

    @Override
    public List<Application> getApplicationsByCandidateUuid(String candidateUuid) throws CRUDOperationException {
        List<ApplicationEntity> applicationEntities = repository.getApplicationEntitiesByCandidate_Uuid(candidateUuid);
        return  applicationEntities.stream()
                .map(ApplicationConverter.INSTANCE::fromEntity)
                .peek(application -> {
                    Cv cv = cvModule.getCvByApplicationUuid(application.getUuid());
                    application.setCv(cv);
                })
                .toList();
    }

    @Override
    public List<Application> getApplicationsByPositionUuid(String positionUuid) throws CRUDOperationException {
        List<ApplicationEntity> applicationEntities = repository.getApplicationEntitiesByPositionUuid(positionUuid);
        return  applicationEntities.stream()
                .map(ApplicationConverter.INSTANCE::fromEntity)
                .peek(application -> {
                    Cv cv = cvModule.getCvByApplicationUuid(application.getUuid());
                    application.setCv(cv);
                })
                .toList();
    }

    @Override
    public List<Application> getAllApplications() throws CRUDOperationException {
        List<ApplicationEntity> applicationEntities = repository.findAll();
        return  applicationEntities.stream()
                .map(ApplicationConverter.INSTANCE::fromEntity)
                .peek(application -> {
                    Cv cv = cvModule.getCvByApplicationUuid(application.getUuid());
                    application.setCv(cv);
                })
                .toList();
    }

    @Override
    public DeleteResponse deleteApplication(String applicationUuid) throws CRUDOperationException {
        try {
            repository.deleteApplicationEntityByUuid(applicationUuid);
            cvModule.deleteCvByApplicationUuid(applicationUuid);
            return new DeleteResponse(OperationStatus.SUCCESS, "Application has been deleted.");
        } catch (Exception exception) {
            return new DeleteResponse(OperationStatus.FAILURE, exception.getMessage());
        }
    }

    @Override
    public DeleteResponse deleteAllApplications() throws CRUDOperationException {
        try {
            repository.deleteAll();
            cvModule.deleteAll();
            return new DeleteResponse(OperationStatus.SUCCESS, "All applications has been deleted.");
        } catch (Exception exception) {
            return new DeleteResponse(OperationStatus.FAILURE, exception.getMessage());
        }
    }
}
