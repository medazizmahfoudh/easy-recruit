package com.easyrecruit.management.ws.rest;

import com.easyrecruit.management.infra.model.entity.Interview;
import com.easyrecruit.management.infra.model.payload.request.InterviewCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.InterviewModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interviews")
public class InterviewWS {

    @Autowired
    private InterviewModule interviewModule;

    @PostMapping("/create")
    public ResponseEntity<Interview> createInterview(InterviewCreateOrUpdateRequest request){
        return ResponseEntity.ok(interviewModule.createInterview(request));
    }
    @PostMapping("/update/{interviewUuid}")
    public ResponseEntity<Interview> updateInterview(InterviewCreateOrUpdateRequest request, @PathVariable("interviewUuid") String interviewUuid){
        return ResponseEntity.ok(interviewModule.updateInterview(request, interviewUuid));
    }
    @GetMapping("/get/{interviewUuid}")
    public ResponseEntity<Interview> getInterviewByUuid(@PathVariable("interviewUuid") String interviewUuid){
        return ResponseEntity.ok(interviewModule.getInterviewByUuid(interviewUuid));
    }
    @GetMapping("/get-pc")
    public ResponseEntity<Interview> getInterviewByPositionUuidAndCandidateUuid(@RequestParam("positionUuid") String positionUuid, @RequestParam("candidateUuid") String candidateUuid){
        return ResponseEntity.ok(interviewModule.getInterviewByPositionUuidAndCandidateUuid(positionUuid, candidateUuid));
    }
    @GetMapping("/get-cr")
    public ResponseEntity<List<Interview>> getInterviewsByCandidateUuidAndRecruiterUuid(@RequestParam("candidateUuid") String candidateUuid, @RequestParam("recruiterUuid") String recruiterUuid){
        return ResponseEntity.ok(interviewModule.getInterviewsByCandidateUuidAndRecruiterUuid(candidateUuid, recruiterUuid));
    }
    @GetMapping("/get-pr")
    public ResponseEntity<List<Interview>> getInterviewsByPositionUuidAndRecruiterUuid(@RequestParam("positionUuid") String positionUuid, @RequestParam("recruiterUuid") String recruiterUuid){
        return ResponseEntity.ok(interviewModule.getInterviewsByPositionUuidAndRecruiterUuid(positionUuid, recruiterUuid));
    }
    @GetMapping("/candidate/{candidateUuid}")
    public ResponseEntity<List<Interview>> getInterviewsByCandidateUuid(@PathVariable("candidateUuid") String candidateUuid){
        return ResponseEntity.ok(interviewModule.getInterviewsByCandidateUuid(candidateUuid));
    }
    @GetMapping("/position/{positionUuid}")
    public ResponseEntity<List<Interview>> getInterviewsByPositionUuid(@PathVariable("positionUuid") String positionIdentifier){
        return ResponseEntity.ok(interviewModule.getInterviewsByPositionUuid(positionIdentifier));
    }
    @GetMapping("/recruiter/{recruiterUuid}")
    public ResponseEntity<List<Interview>> getInterviewsByRecruiterUuid(@PathVariable("recruiterUuid") String recruiterUuid){
        return ResponseEntity.ok(interviewModule.getInterviewsByRecruiterUuid(recruiterUuid));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Interview>> getAllInterviews(){
        return ResponseEntity.ok(interviewModule.getAllInterviews());
    }
    @DeleteMapping("/delete/{interviewUuid}")
    public ResponseEntity<DeleteResponse> deleteInterviewByUuid(@PathVariable("interviewUuid") String interviewUuid ){
        return ResponseEntity.ok(interviewModule.deleteInterviewByUuid(interviewUuid));
    }
    @DeleteMapping("/delete-all")
    public ResponseEntity<DeleteResponse> deleteApplication(){
        return ResponseEntity.ok(interviewModule.deleteAllInterviews());
    }
}
