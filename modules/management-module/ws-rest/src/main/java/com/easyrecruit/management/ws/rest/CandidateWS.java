package com.easyrecruit.management.ws.rest;

import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.infra.model.payload.request.CandidateCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.CandidateModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateWS {

    @Autowired
    private CandidateModule candidateModule;

    @PostMapping("/create")
    public ResponseEntity<Candidate> createCandidate(@RequestBody CandidateCreateOrUpdateRequest request){
        return ResponseEntity.ok(candidateModule.createCandidate(request));
    }
    @PutMapping("/update/{candidateUuid}")
    public ResponseEntity<Candidate> updateCandidate(@RequestBody CandidateCreateOrUpdateRequest request, @PathVariable("candidateUuid") String candidateUuid){
        return ResponseEntity.ok(candidateModule.updateCandidate(request, candidateUuid));
    }
    @GetMapping("/{candidateUuid}")
    public ResponseEntity<Candidate> getCandidate(@PathVariable("candidateUuid") String candidateUuid){
        return ResponseEntity.ok(candidateModule.getCandidateByUuid(candidateUuid));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Candidate>> getAllCandidate(){
        return ResponseEntity.ok(candidateModule.getAllCandidates());
    }
    @DeleteMapping("/delete/{candidateUuid}")
    public ResponseEntity<DeleteResponse> deleteApplication(@PathVariable("candidateUuid") String candidateUuid ){
        return ResponseEntity.ok(candidateModule.deleteCandidate(candidateUuid));
    }
    @DeleteMapping("/delete-all")
    public ResponseEntity<DeleteResponse> deleteAllCandidates(){
        return ResponseEntity.ok(candidateModule.deleteAllCandidates());
    }
}
