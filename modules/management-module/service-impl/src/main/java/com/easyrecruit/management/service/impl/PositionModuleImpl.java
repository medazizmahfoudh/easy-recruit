package com.easyrecruit.management.service.impl;

import com.easyrecruit.management.dal.document.PositionDocument;
import com.easyrecruit.management.dal.repository.PositionRepository;
import com.easyrecruit.management.infra.model.entity.Position;
import com.easyrecruit.management.infra.model.payload.request.PositionCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.PositionModule;
import com.easyrecruit.management.service.api.exception.CRUDOperation;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;
import com.easyrecruit.management.service.impl.converter.PositionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionModuleImpl implements PositionModule {

    @Autowired
    private PositionRepository repository;

    @Override
    public Position createPosition(PositionCreateOrUpdateRequest request) throws CRUDOperationException {

        Position position = new Position()
                .setName(request.name())
                .setDescription(request.description())
                .setLocation(request.location())
                .setRequiredSkills(request.skills());

        PositionDocument positionDocument = PositionConverter.INSTANCE.toEntity(position);
        repository.save(positionDocument);

        return position;
    }

    @Override
    public Position updatePosition(PositionCreateOrUpdateRequest request, String positionUuid) throws CRUDOperationException {
        return null;
    }

    @Override
    public Position getPositionByUuid(String uuid) throws CRUDOperationException {
        Optional<PositionDocument> positionDocument = repository.getPositionDocumentByUuid(uuid);
        if (positionDocument.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Position for the given uuid doesn't exist");
        }
        return PositionConverter.INSTANCE.fromEntity(positionDocument.get());
    }

    @Override
    public List<Position> getPositionsByName(String name) throws CRUDOperationException {
        return List.of();
    }

    @Override
    public List<Position> getPositionsByLocation(String location) throws CRUDOperationException {
        return List.of();
    }

    @Override
    public List<Position> getAllPositions() {
        List<PositionDocument> positionDocuments = repository.findAll();
        return positionDocuments
                .stream()
                .map(PositionConverter.INSTANCE::fromEntity)
                .toList();
    }

    @Override
    public DeleteResponse deleteAllPositions() {
        return null;
    }

    @Override
    public DeleteResponse deletePositionByUuid(String uuid) {
        return null;
    }

    @Override
    public DeleteResponse deletePositionsByName(String name) {
        return null;
    }

    @Override
    public DeleteResponse deletePositionsByLocation(String location) {
        return null;
    }
}
