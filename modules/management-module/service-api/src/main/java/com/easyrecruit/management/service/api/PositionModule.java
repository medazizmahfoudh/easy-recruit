package com.easyrecruit.management.service.api;

import com.easyrecruit.management.infra.model.document.Position;
import com.easyrecruit.management.infra.model.payload.request.PositionCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;

import java.util.List;

public interface PositionModule {

    Position createPosition(PositionCreateOrUpdateRequest request) throws CRUDOperationException;
    Position updatePosition(PositionCreateOrUpdateRequest request, String positionUuid ) throws CRUDOperationException;
    Position getPositionByUuid(String uuid) throws CRUDOperationException;
    List<Position> getPositionsByName(String name) throws CRUDOperationException;
    List<Position> getPositionsByLocation(String location) throws CRUDOperationException;
    List<Position> getAllPositions();
    DeleteResponse deleteAllPositions();
    DeleteResponse deletePositionByUuid(String uuid);
    DeleteResponse deletePositionsByName(String name);
    DeleteResponse deletePositionsByLocation(String location);
}
