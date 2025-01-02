package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.document.PositionDocument;
import com.easyrecruit.management.infra.model.document.Position;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PositionConverter {
    PositionConverter INSTANCE = Mappers.getMapper(PositionConverter.class);
    PositionDocument toEntity(Position Position);
    Position fromEntity(PositionDocument PositionDocument);
}
