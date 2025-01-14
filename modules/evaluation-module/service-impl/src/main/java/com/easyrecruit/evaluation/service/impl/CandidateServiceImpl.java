package com.easyrecruit.evaluation.service.impl;


import com.easyrecruit.evaluation.service.CandidateService;
import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.infra.model.entity.ApplicationStatus;
import com.easyrecruit.management.infra.model.entity.Evaluation;
import com.easyrecruit.management.infra.model.entity.EvaluationStatus;
import com.easyrecruit.management.service.api.ApplicationModule;
import com.easyrecruit.management.service.api.EvaluationModule;
import org.bson.RawBsonDocument;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final LLMServiceImpl llmService ;
    private final EvaluationModule evaluationModule;
    private final ApplicationModule applicationModule;

    @Autowired
    public CandidateServiceImpl(LLMServiceImpl llmService,
                                EvaluationModule evaluationModule,
                                ApplicationModule applicationModule
                                ){
        this.llmService=llmService;
        this.evaluationModule=evaluationModule;
        this.applicationModule=applicationModule;
    }


    @Override
    public Evaluation processApplication(Application application) {

        System.out.println("Processing candidate ID= "+application.getCandidate().getId()+" for application "+application.getId());
        String jobDescription = application.getPosition().getDescription();
        Binary binarycv = application.getCv().getDocument();

        String  cv = convertBinaryToString(binarycv);

        // Inference
        HashMap<String,String> results = llmService.evaluateCandidateJson(jobDescription,cv);
        Double  score = Double.parseDouble(results.get("score"));
        String feedback = results.get("feedback");

        // Create Evaluation
        Evaluation evaluation = evaluationModule.getEvaluation(application.getUuid());
        evaluation.setFeedback(feedback);
        evaluation.setScore(score);
        evaluation.setStatus(EvaluationStatus.COMPLETED);

        evaluationModule.updateEvaluation(evaluation);

        return evaluation;

    }

    @Override
    public Evaluation processApplicationById(String uiid){
        Application app = applicationModule.getApplicationByUuid(uiid);
        return processApplication(app);

    }

    @Override
    public List<Evaluation> processApplicationByStatus() {
        List<Application> applications=applicationModule.getAllApplications();
        List<Evaluation> results = new ArrayList<>();
        for (Application app : applications) {
            if (app.getStatus() == ApplicationStatus.PRELIMINARY) {
                results.add(processApplication(app));
            }
        }
        return results;
    }
        public static String convertBinaryToString(Binary bsonData){
            // Convert a BinaryFile to a String
            RawBsonDocument rawBsonDocument = RawBsonDocument.parse(bsonData.toString());
            return rawBsonDocument.toString();


    }




    }

