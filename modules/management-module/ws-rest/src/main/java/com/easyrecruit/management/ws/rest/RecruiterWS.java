package com.easyrecruit.management.ws.rest;

import com.easyrecruit.management.infra.model.entity.Recruiter;
import com.easyrecruit.management.infra.model.payload.request.RecruiterCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.RecruiterModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruiters")
public class RecruiterWS {

    @Autowired
    private RecruiterModule recruiterModule;

    @PostMapping("/create")
    public ResponseEntity<Recruiter> createRecruiter(@RequestBody RecruiterCreateOrUpdateRequest request){
        return ResponseEntity.ok(recruiterModule.createRecruiter(request));
    }
    @PutMapping("/update/{recruiterUuid}")
    public ResponseEntity<Recruiter> updateRecruiter(@RequestBody RecruiterCreateOrUpdateRequest request, @PathVariable("recruiterUuid") String recruiterUuid){
        return ResponseEntity.ok(recruiterModule.updateRecruiter(request, recruiterUuid));
    }
    @GetMapping("/{recruiterUuid}")
    public ResponseEntity<Recruiter> getRecruiter(@PathVariable("recruiterUuid") String recruiterUuid){
        return ResponseEntity.ok(recruiterModule.getRecruiterByUuid(recruiterUuid));
    }
    @GetMapping("/get")
    public ResponseEntity<List<Recruiter>> getRecruiterByFullname(@RequestParam("fullname") String fullname){
        return ResponseEntity.ok(recruiterModule.getRecruiterByFullname(fullname));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Recruiter>> getAllRecruiters(){
        return ResponseEntity.ok(recruiterModule.getAllRecruiters());
    }
    @DeleteMapping("/delete/{recruiterUuid}")
    public ResponseEntity<DeleteResponse> deleteRecruiter(@PathVariable("recruiterUuid") String recruiterUuid ){
        return ResponseEntity.ok(recruiterModule.deleteRecruiter(recruiterUuid));
    }
    @PostMapping("/delete-bulk")
    public ResponseEntity<DeleteResponse> deleteRecruiterBulkByUuid(@RequestBody List<String> uuids ){
        return ResponseEntity.ok(recruiterModule.deleteRecruiterBulkByUuid(uuids));
    }
    @DeleteMapping("/delete-all")
    public ResponseEntity<DeleteResponse> deleteAllRecruiters(){
        return ResponseEntity.ok(recruiterModule.deleteAllRecruiters());
    }
}
