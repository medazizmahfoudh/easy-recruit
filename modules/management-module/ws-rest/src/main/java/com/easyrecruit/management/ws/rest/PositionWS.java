package com.easyrecruit.management.ws.rest;

import com.easyrecruit.management.infra.model.document.Position;
import com.easyrecruit.management.infra.model.payload.request.PositionCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.PositionModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionWS {

    @Autowired
    private PositionModule positionModule;

    @PostMapping("/create")
    public ResponseEntity<Position> createPosition(@RequestBody PositionCreateOrUpdateRequest request){
        return ResponseEntity.ok(positionModule.createPosition(request));
    }
    @PutMapping("/update/{positionUuid}")
    public ResponseEntity<Position> updatePosition(@RequestBody PositionCreateOrUpdateRequest request, @PathVariable("positionUuid") String positionUuid){
        return ResponseEntity.ok(positionModule.updatePosition(request, positionUuid));
    }
    @GetMapping("/{positionIdentifier}")
    public ResponseEntity<Position> getApplication(@PathVariable("positionIdentifier") String positionIdentifier){
        return ResponseEntity.ok(positionModule.getPositionByUuid(positionIdentifier));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Position>> getAllPositions(){
        return ResponseEntity.ok(positionModule.getAllPositions());
    }
    @DeleteMapping("/delete/{positionUuid}")
    public ResponseEntity<DeleteResponse> deletePosition(@PathVariable("positionUuid") String positionUuid ){
        return ResponseEntity.ok(positionModule.deletePositionByUuid(positionUuid));
    }

}
