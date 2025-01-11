package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.document.PositionDocument;
import com.easyrecruit.management.infra.model.entity.Position;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-11T19:29:50+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class PositionConverterImpl implements PositionConverter {

    @Override
    public PositionDocument toEntity(Position Position) {
        if ( Position == null ) {
            return null;
        }

        PositionDocument positionDocument = new PositionDocument();

        positionDocument.setId( Position.getId() );
        positionDocument.setUuid( Position.getUuid() );
        positionDocument.setName( Position.getName() );
        positionDocument.setDescription( Position.getDescription() );
        positionDocument.setLocation( Position.getLocation() );

        return positionDocument;
    }

    @Override
    public Position fromEntity(PositionDocument PositionDocument) {
        if ( PositionDocument == null ) {
            return null;
        }

        Position position = new Position();

        position.setId( PositionDocument.getId() );
        position.setUuid( PositionDocument.getUuid() );
        position.setName( PositionDocument.getName() );
        position.setDescription( PositionDocument.getDescription() );
        position.setLocation( PositionDocument.getLocation() );

        return position;
    }
}
