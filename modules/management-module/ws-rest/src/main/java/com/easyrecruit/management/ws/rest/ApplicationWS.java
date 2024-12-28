package com.easyrecruit.management.ws.rest;

import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.infra.model.payload.request.ApplicationSubmitOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.ApplicationModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationWS {

    @Autowired
    private ApplicationModule applicationModule;

    @PostMapping("/create")
    public ResponseEntity<Application> createApplication(
            @RequestBody ApplicationSubmitOrUpdateRequest request){
        return ResponseEntity.ok(applicationModule.createApplication(request));
    }
    @GetMapping("/get/{applicationUuid}")
    public ResponseEntity<Application> getApplication(@PathVariable("applicationUuid") String applicationIdentifier){
        return ResponseEntity.ok(applicationModule.getApplicationByUuid(applicationIdentifier));
    }
    @GetMapping("/get")
    public ResponseEntity<Application> getApplicationByCandidateUuidAndPositionUuid(@RequestParam("candidateUuid") String candidateUuid, @RequestParam("positionUuid") String positionUuid){
        return ResponseEntity.ok(applicationModule.getApplicationByCandidateUuidAndPositionUuid(candidateUuid, positionUuid));
    }
    @GetMapping("/candidate/{candidateUuid}")
    public ResponseEntity<List<Application>> getApplicationsByCandidateUuid(@PathVariable("candidateUuid") String candidateUuid){
        return ResponseEntity.ok(applicationModule.getApplicationsByCandidateUuid(candidateUuid));
    }
    @GetMapping("/position/{positionIdentifier}")
    public ResponseEntity<List<Application>> getApplicationsByPosition(@PathVariable("positionIdentifier") String positionIdentifier){
        return ResponseEntity.ok(applicationModule.getApplicationsByPositionUuid(positionIdentifier));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Application>> getAllApplications(){
        return ResponseEntity.ok(applicationModule.getAllApplications());
    }
    @DeleteMapping("/delete/{applicationUuid}")
    public ResponseEntity<DeleteResponse> deleteApplication(@PathVariable("applicationUuid") String applicationUuid ){
        return ResponseEntity.ok(applicationModule.deleteApplication(applicationUuid));
    }
}
