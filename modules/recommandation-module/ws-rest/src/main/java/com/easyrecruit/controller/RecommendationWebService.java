package com.easyrecruit.controller;


import com.easyrecruit.serviceApi.RecommendationServiceAPI;
import com.easyrecruit.serviceApi.TrainingServiceAPI;
import com.eniso.entities.ApplicationReport;
import com.eniso.entities.Training;
import com.eniso.payloads.requests.TrainingCreationRequest;
import io.micronaut.http.annotation.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
public class RecommendationWebService {

    @Autowired
    private RecommendationServiceAPI recommendationServiceAPI;
    @Autowired
    private TrainingServiceAPI trainingServiceAPI;


    @PostMapping("/processApplications")
    public void processApplications(){
        recommendationServiceAPI.processApplications();
    }

    @GetMapping("/suggestedTrainings")
    public ResponseEntity<List<Training>> getSuggestedTrainings(
            ApplicationReport report
    ){
        return ResponseEntity.ok(
                trainingServiceAPI.suggestTrainings(report)
        );
    }

    @PostMapping("/createTraining")
    public void createTraining(
            @RequestBody TrainingCreationRequest request
            ){
        trainingServiceAPI.createTraining(request);
    }

}
