package com.easyrecruit.management.dal.repository;

import com.easyrecruit.management.dal.document.CvDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CvRepository extends MongoRepository<CvDocument, String> {

    Optional<CvDocument> getCvDocumentByApplicationUuid(String applicationUuid);
    Optional<CvDocument> getCvDocumentByUuid(String uuid);
    void deleteByApplicationUuid(String applicationUuid);

}

