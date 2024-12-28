package com.easyrecruit.management.dal.repository;

import com.easyrecruit.management.dal.document.PositionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends MongoRepository<PositionDocument, String> {

    Optional<PositionDocument> getPositionDocumentByUuid(String uuid);
}
